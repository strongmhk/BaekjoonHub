import java.util.*;

class Solution {
    public int solution(int[] credits, int target) {
        int[] dp = new int[target + 1];
        int INF = target + 1;

        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 1부터 target까지 dp 채우기
        for (int i = 1; i <= target; i++) {
            for (int credit : credits) {
                if (i - credit < 0) continue;
                if (dp[i - credit] == INF) continue;

                dp[i] = Math.min(dp[i], dp[i - credit] + 1);
            }
        }

        return dp[target] == INF ? -1 : dp[target];
    }
}