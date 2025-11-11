import java.io.*;
import java.util.*;

class Main {
    static int solution(int[] coin, int M, int N) {
        int[] dy = new int[M + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        dy[0] = 0;
        for(int i = 0; i < N; i ++) {
            for(int j = coin[i]; j <= M; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[M];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] coin = new int[N];

        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        System.out.println(solution(coin, M, N));
    }
}