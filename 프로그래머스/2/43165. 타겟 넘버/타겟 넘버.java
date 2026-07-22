class Solution {
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return result;
    }
    
    static void dfs(int num, int i, int target, int[] numbers) {
        if (i == numbers.length) {
            if (num == target) result++;
            return;
        } 
        
        dfs(num + numbers[i], i + 1, target, numbers);
        dfs(num - numbers[i], i + 1, target, numbers);
    }
}