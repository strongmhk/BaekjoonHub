import java.io.*;
import java.util.*;

class Main {
    static int N, L;
    static int answer;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (isGo(i, 0, true)) answer++;
            if (isGo(0, i, false)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isGo(int x, int y, boolean isRow) {
        int[] height = new int[N];
        boolean[] isRunway = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (isRow) height[i] = map[x][i];
            else height[i] = map[i][y];
        }

        for (int i = 0; i < N - 1; i++) {
            int diff = height[i] - height[i + 1];

            if (Math.abs(diff) >= 2) return false;

            if (diff == 0) continue;

            // 내려가는 경우
            if (diff == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (!isIn(j) || height[i + 1] != height[j] || isRunway[j])
                        return false;

                    isRunway[j] = true;
                }
                i += L - 1;
            }

            // 올라가는 경우
            else if (diff == -1) {
                for (int j = i; j >= i - L + 1; j--) {
                    if (!isIn(j) || height[i] != height[j] || isRunway[j])
                        return false;

                    isRunway[j] = true;
                }
            }
        }

        return true;
    }

    public static boolean isIn(int x) {
        return 0 <= x && x < N;
    }
}
