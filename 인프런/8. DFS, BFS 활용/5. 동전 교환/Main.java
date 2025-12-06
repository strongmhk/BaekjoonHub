import java.io.*;
import java.util.*;

class Main {
    static int N = 0, M = 0, min = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] coins) {
        if (sum > M) return;
        if (L >= min) return;
        if (sum == M) {
            min = Math.min(L, min);
        } else {
            for(int i = 0; i < N; i++) {
                DFS(L + 1, sum + coins[i], coins);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine(), 10);

        Integer[] coins = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken(), 10);
        }

        Arrays.sort(coins, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine(), 10);

        T.DFS(0, 0, coins);

        System.out.println(min);

    }
}