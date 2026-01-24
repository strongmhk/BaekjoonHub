import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        dfs(1, 1, 0);
        System.out.println(answer < 4 ? answer : -1);
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (pos > 1 && ladder[j][pos - 1]) {
                    pos--;
                } else if (pos < N && ladder[j][pos]) {
                    pos++;
                }
            }
            if (pos != i) return false;
        }
        return true;
    }

    static void dfs(int x, int y, int count) {
        if (count >= answer) return;
        if (check()) {
            answer = count;
            return;
        }
        if (count == 3) return;

        for (int i = x; i <= H; i++) {
            int start = (i == x) ? y : 1;
            for (int j = start; j < N; j++) {
                if (ladder[i][j]) continue;
                if (j > 1 && ladder[i][j - 1]) continue;
                if (j < N - 1 && ladder[i][j + 1]) continue;

                ladder[i][j] = true;
                dfs(i, j + 2, count + 1);
                ladder[i][j] = false;
            }
        }
    }
}
