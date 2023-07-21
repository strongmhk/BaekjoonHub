import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

      
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

       
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total = (total + dp[n][i]) % MOD;
        }

        System.out.println(total);
    }
}
