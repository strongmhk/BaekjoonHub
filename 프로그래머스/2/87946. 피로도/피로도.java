class Solution {
    static boolean[] visited;
    static int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return result;
    }
    
    static void dfs(int count, int point, int[][] dungeons) {
        result = Math.max(result, count);
        
        // 수행 작업
        for (int i = 0; i < dungeons.length; i++) {
            int requiredPoint = dungeons[i][0];
            int consumedPoint = dungeons[i][1];
            
            if (!visited[i] && point >= requiredPoint) {
                visited[i] = true;
                dfs(count + 1, point - consumedPoint, dungeons);
                visited[i] = false;
            }
        }
    }
}