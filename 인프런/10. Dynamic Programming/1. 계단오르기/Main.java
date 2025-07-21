import java.io.*;

class Main {
    static int solution(int[] dp, int N) {
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        System.out.println(solution(dp, N));
    }

}