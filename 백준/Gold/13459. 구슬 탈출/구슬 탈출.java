import java.io.*;
import java.util.*; 

class Point {
    public int rx, ry;
    public int bx, by;
    public int count;
    
    public Point(int rx, int ry, int bx, int by, int count){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

class Main {
    static int N, M;
    
    static int[][] board = new int[11][11];
    static boolean[][][][] visited = new boolean[11][11][11][11];
    
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int result = 0;

    static void whof(Point cur, int x, int y, int i) { // i를 기준으로 마지막 위치 재조정
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        if (i == 0) { // 오른쪽
            if (cur.by > cur.ry) { // 이동 전 파란 구슬이 더 오른쪽에 있었던 경우
                rx = x;
                bx = x;
                
                ry = y - 1; // 빨간 구슬이 한칸 왼쪽으로 이동
                by = y;
            }
            else {
                rx = x;
                bx = x;
                
                ry = y;
                by = y - 1; // 파란 구슬이 한칸 왼쪽으로 이동
            }
        }
        else if (i == 1) { // 왼쪽
            if (cur.by > cur.ry) { // 이동 전 파란 구슬이 더 오른쪽에 있었던 경우
                rx = x;
                bx = x;
                
                ry = y;
                by = y + 1; // 파란 구슬을 한칸 오른쪽으로 이동
            }
            else {
                rx = x;
                bx = x;
                
                ry = y + 1;
                by = y;
            }
        }
        else if (i == 2) { // 아래쪽
            if (cur.bx > cur.rx) { // 이동 전 파란 구슬이 더 아래에 있던 경우
                rx = x - 1; // 빨간 구슬을 위쪽으로 이동
                bx = x;
                
                ry = y;
                by = y;
            }
            else {
                rx = x;
                bx = x - 1;
                
                ry = y;
                by = y;
            }
        }
        else { // (i == 3) -> 위쪽
            if (cur.bx > cur.rx) { // 이동 전 파란 구슬이 더 아래에 있던 경우
                rx = x;
                bx = x + 1; // 파란 구슬을 아래 쪽으로 이동
            
                ry = y;
                by = y;
            }
            else {
                rx = x + 1;
                bx = x;
                
                ry = y;
                by = y;
            }
        }
        
        if (visited[rx][ry][bx][by] == false) { // 마지막 위치 방문 처리
            visited[rx][ry][bx][by] = true;
            queue.add(new Point(rx, ry, bx, by, cur.count + 1));
        }
    }

    static void bfs(Point start) {
        queue.add(start);
        visited[start.rx][start.ry][start.bx][start.by] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if (cur.count >= 10) return;
            
            for (int i = 0; i < 4; i++) {
                int rx = cur.rx;
                int ry = cur.ry;
                
                boolean rMove = true; // 빨간 구슬을 움직일 수 있는 상태인지
                boolean rGoal = false; // 빨간 구슬이 구멍에 도달했는지
                
                while(rMove) {
                    rx = rx + dx[i];
                    ry = ry + dy[i];
                    
                    if (rx >= 1 && rx <= N && ry >= 1 && ry <= M) {
                        if (board[rx][ry] == 1) { // 벽일 경우
                            rMove = false; // 더 이상 이동 불가
                            rx = rx - dx[i]; // 위치 재조정
                            ry = ry - dy[i];
                        }
                        else if (board[rx][ry] == 2) { // 구멍일 경우
                            rGoal = true; // 목적지 도착
                            rMove = false;
                        }
                    }
                }
                
                int bx = cur.bx;
                int by = cur.by;
                
                boolean bMove = true; // 파란 구슬을 움직일 수 있는 상태인지
                boolean bGoal = false; // 파란 구슬이 구멍에 도달했는지
                
                while(bMove) {
                    bx = bx + dx[i];
                    by = by + dy[i];
                    
                    if (bx >= 1 && bx <= N && by >= 1 && by <= M) {
                        if (board[bx][by] == 1) {
                            bMove = false;
                            bx = bx - dx[i];
                            by = by - dy[i];
                        }
                        else if (board[bx][by] == 2) {
                            bGoal = true;
                            bMove = false;
                        }
                    }
                }
                
                if (rGoal == true && bGoal == false) { // 빨간 구슬이 구멍에 들어가고 파란 구슬은 들어가지 않은 경우에만 성공
                    result = 1;
                    return;
                }
                else if (rGoal == false && bGoal == false) {
                    if (rx == bx && ry == by) { // 2개의 공의 마지막 위치가 겹치는 경우 위치 재조정
                        whof(cur, rx, ry, i); 
                    }
                    else if (visited[rx][ry][bx][by] == false) { // 2개의 공이
                        visited[rx][ry][bx][by] = true;
                        queue.add(new Point(rx, ry, bx, by, cur.count + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        for (int x = 1; x <= N; x++) {
            String line = br.readLine();
            for (int y = 1; y <= M; y++) {
                char c = line.charAt(y - 1);
                
                if (c == '.') // 빈칸
                    board[x][y] = 0;
                else if (c == '#') // 벽
                    board[x][y] = 1;
                else if (c == 'O') // 구멍
                    board[x][y] = 2;
                else if (c == 'R') {
                    rx = x;
                    ry = y;
                }
                else if (c == 'B') {
                    bx = x;
                    by = y;
                }
            }
        }
        
        bfs(new Point(rx, ry, bx, by, 0));
        
        System.out.println(result);
    }
}
