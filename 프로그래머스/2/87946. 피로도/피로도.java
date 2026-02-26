class Solution {
    static int max = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];

        DFS(k, 0, n, dungeons);
        
        return max;
    }
    
    static void DFS(int curDegree, int depth, int n, int[][] dungeons) {
        max = Math.max(max, depth);
        
        for (int i = 0; i < n; i++) {        
            int minReqDegree = dungeons[i][0];
            int reqDegree = dungeons[i][1];
            
            if (!visited[i] && curDegree >= minReqDegree) {
                visited[i] = true;
                DFS(curDegree - reqDegree, depth + 1, n, dungeons);
                visited[i] = false;
            }
        }
    }
}