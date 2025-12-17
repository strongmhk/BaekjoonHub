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
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;
        
        while(!queue.isEmpty()) {
            Point cp = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[cp.x][cp.y] + 1;
                }
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[8][8];
        dis = new int[8][8];
        
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }
        
        T.BFS(1, 1);
        
        if (dis[7][7] == 0) System.out.println("-1");
        else System.out.println(dis[7][7]);
    }
}