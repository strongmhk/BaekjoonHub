import java.io.*;
import java.util.*;

class Point {
    public int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int N, L, R;
    static int count = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean isMove = false;
    static ArrayList<Point> unionXY = new ArrayList<>();
    
    static final int dx[] = {1, -1, 0, 0};
    static final int dy[] = {0, 0, 1, -1};
    
    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        unionXY.add(new Point(x, y));
    
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            x = p.x;
            y = p.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (visited[nx][ny] == false && L <= Math.abs(map[x][y] - map[nx][ny]) && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                        isMove = true;
                        visited[nx][ny] = true;
                        unionXY.add(new Point(nx, ny));
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        
        // BFS가 끝나면 인구 이동 결과 map에 넣기
        
        // 연합의 합 구하기
        int sum = 0;
        for (int i = 0; i < unionXY.size(); i++) {
            Point p = unionXY.get(i);
            sum += map[p.x][p.y];
        }

        // 연합인 각 나라 인구수 계산
        for (int i = 0; i < unionXY.size(); i++) {
            Point p = unionXY.get(i);
            map[p.x][p.y] = sum / unionXY.size();
        }
        
        unionXY.removeAll(unionXY);
        
    }
    
    static void move() {
        while(true) {
            isMove = false;
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == false) {
                        bfs(i, j); // 방문하지 않은 상태면 BFS 시작
                    }
                }
            }
            
            if (isMove == false) break; // 국경 이동이 없으면 
            else count++; // 국경 이동이 있었다면 일수 추가
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        move();
        
        System.out.println(count);
    }
}