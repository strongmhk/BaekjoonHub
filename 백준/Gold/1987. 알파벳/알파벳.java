import java.io.*;
import java.util.*;

class Main {
    static char[][] board;
    static boolean[] used = new boolean[26];
    static int R, C;
    static int result = Integer.MIN_VALUE;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int len) {
        result = Math.max(result, len);
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            
            int idx = board[nr][nc] - 'A';
            if (used[idx] == true) continue;
            
            used[idx] = true;
            dfs(nr, nc, len + 1);
            used[idx] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        used[board[0][0] - 'A'] = true;
        
        dfs(0, 0, 1);
        
        System.out.println(result);
    }
}