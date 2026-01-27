import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int maxCount = Integer.MIN_VALUE;
		static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    
    static int dfs(int x, int y, int h) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == false &&map[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        
        return 1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        int maxHeight = Integer.MIN_VALUE;
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }
        
        for (int h = 0; h < maxHeight; h++) {
            int tempCount = 0;
            visited = new boolean[N][N];
            
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && map[x][y] > h) {
                        tempCount += dfs(x, y, h);
                    }
                }
            }
            
            maxCount = Math.max(maxCount, tempCount);
        }
        
        
        System.out.println(maxCount);
    }
}