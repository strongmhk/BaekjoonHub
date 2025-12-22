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
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] box;
    static int[][] dis;
    static Queue<Point> queue = new LinkedList<>();
    static int N = 0, M = 0;

    public void BFS() {
        while(!queue.isEmpty()) {
            Point cp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    box[nx][ny] = 1;
                    dis[nx][ny] = dis[cp.x][cp.y] + 1; // 방문할 때까지 걸린 날짜 계산
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken(), 10);
        N = Integer.parseInt(st.nextToken(), 10);

        box = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken(), 10);
                if (box[i][j] == 1) queue.offer(new Point(i, j));
            }
        }

        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i< N; i++){
            for(int j = 0; j < M; j++){
                if (box[i][j]==0) flag=false;
            }
        }

        if(flag) {
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    answer = Math.max(answer, dis[i][j]); // BFS 특성상 최초로 방문한 시점이 최소 날짜가 되므로 최댓값을 구해야함
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}