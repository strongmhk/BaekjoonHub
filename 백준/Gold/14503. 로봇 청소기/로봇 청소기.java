import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int result = 0;
    static int[][] board;

    // 북(0), 동(1), 남(2), 서(3)
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1};
    
    static int getCountClockDir(int curDir) {
        return (curDir == 0) ? 3 : curDir - 1;
    }
    
    static int getBackDir(int curDir) {
        return (curDir + 2) % 4;
    }

    static void dfs(int r, int c, int dir) {
        // 현재 칸 청소
        if (board[r][c] == 0) {
            board[r][c] = -1;
            result++;
        }
        
        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            dir = getCountClockDir(dir);
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            // 청소되지 않은 빈칸이면 이동
            if (board[nr][nc] == 0) {
                dfs(nr, nc, dir);
                return;
            }
        }
        
        // 네 방향 모두 불가능 -> 후진
        int backDir = getBackDir(dir);
        int br = r + dr[backDir];
        int bc = c + dc[backDir];
        
        if (board[br][bc] != 1) { // 벽이 아니면 후진
            dfs(br, bc, dir); // 후진시 원래 방향은 유지
        }
        // 벽이면 종료
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(r, c, d);
        
        System.out.println(result);
    }
}
