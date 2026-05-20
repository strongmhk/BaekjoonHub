class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    static void DFS(int[] numbers, int target, int i, int num) {
        if (i == numbers.length) {
            if (num == target) answer++;
            return;
        } 
        
        DFS(numbers, target, i + 1, num + numbers[i]);
        DFS(numbers, target, i + 1, num - numbers[i]);
    }
}