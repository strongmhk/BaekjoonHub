import java.io.*;

class Main {
    static int solution(int N) {
        int[] dp = new int[N+2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N+1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

}
