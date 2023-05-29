import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; // N까지 계산해줘야 하므로 크기 N+1

        // dp[0], dp[1] == 0
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1; // 1을 빼주기
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1); // 2나눠주기
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1); // 3나눠주기

        }

        System.out.println(dp[N]);
    }

}