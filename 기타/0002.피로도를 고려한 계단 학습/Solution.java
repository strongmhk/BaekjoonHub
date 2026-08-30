public class Solution {
    public long minimumStairFatigue(int[] fatigue) {
        int n = fatigue.length;
        // Long.MAX_VALUE를 그대로 사용하고 피로도를 더하면 오버플로가 발생할 수 있으므로 충분히 큰 값으로 나눠 사용
        long INF = Long.MAX_VALUE / 4;

        // dp[i][0]: i번 계단에 마지막으로 한 칸 이동해서 도착한 최소 누적 피로도
        // dp[i][1]: i번 계단에 마지막으로 두 칸 이동해서 도착한 최소 누적 피로도
        long[][] dp = new long[n + 1][2];

        // 지면
        dp[0][0] = 0L;
        dp[0][1] = INF; // 도달 불가능한 상태는 매우 큰 값으로 표현, 0으로 선언시 min 연산에 영향을 미침

        for (int stair = 1; stair <= n; stair++) {
            long currentFatigue = fatigue[stair - 1];

            // dp[stair][0] 구하기
            // dp[i][0] = min(dp[i-1][0], dp[i-1][1]) + fatigue[i - 1]
            dp[stair][0] = Math.min(dp[stair - 1][0], dp[stair - 1][1]) + currentFatigue;

            // dp[stair][1] 구하기
            // dp[i][1] = dp[i-2][0] + fatigue[i - 1]
            if (stair == 1) {
                dp[stair][1] = INF;
            } else {
                dp[stair][1] = dp[stair - 2][0] + currentFatigue;
            }
        }

        return Math.min(dp[n][0], dp[n][1]);
    }
}