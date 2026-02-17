class Solution {
    static int[] nums;
    static int n;
    static int answer = 0;
    static int t;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        nums = new int[n];
        t = target;
        
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i];
        }
        
        dfs(0, 0);
        
        return answer;
    }
    
    static void dfs(int len, int sum) {
        if (len == n) {
            if (sum == t) answer++;
            return;
        } else {
            dfs(len + 1, sum + nums[len]);
            dfs(len + 1, sum - nums[len]);
        }
    }
}