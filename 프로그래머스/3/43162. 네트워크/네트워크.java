class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) continue;
            
            // 네트워크 시작
            answer++;
            
            // dfs로 연결된 모든 노드 방문 처리
            dfs(computers, i);
        }
        
        return answer;
    }
    
    static void dfs(int[][] computers, int i) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (i == j) continue;
            if (computers[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(computers, j);
            }
        }
    }
}