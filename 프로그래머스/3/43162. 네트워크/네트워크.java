class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i, n, computers);
            }
        }

        return answer;
    }

    static void DFS(int start, int n, int[][] computers) {
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                DFS(i, n, computers);
            }
        }
    }
}