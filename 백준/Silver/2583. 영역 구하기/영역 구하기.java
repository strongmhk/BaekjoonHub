import java.io.*;
import java.util.*;

class Main {
    
    static int M, N, K;
    static int[][] board;
    static boolean[][] visited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int area;
    
    static void dfs(int y, int x) {
        visited[y][x] = true;
        area++;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
            if (visited[ny][nx]) continue;
            if (board[ny][nx] == 1) continue;
            
            dfs(ny, nx);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y][x] == 0 && !visited[y][x]) {
                    area = 0;
                    dfs(y, x);
                    result.add(area);
                }
            }
        }
        
        Collections.sort(result);
        
        System.out.println(result.size());
        for (int a : result) {
            System.out.print(a + " ");
        }
    }
    
}