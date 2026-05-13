class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                DFS(i, n, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    static void DFS(int start, int n, int[][] computers, boolean[] visited) {
        visited[start] = true;

        for (int j = 0; j < n; j++) {
            if (visited[j] == false && computers[start][j] == 1) {
                DFS(j, n, computers, visited);
            }
        }
    }
}