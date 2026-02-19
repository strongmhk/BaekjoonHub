import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int w, h;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) break;
            
            map = new int[h][w];
            visited = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == false && map[i][j] == 1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }
            
            sb.append(count + "\n");
        }
        
        System.out.println(sb);
    }
    
    static void DFS(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (visited[nx][ny] == true || map[nx][ny] == 0) continue;
            
            DFS(nx, ny);
        }
    }
}