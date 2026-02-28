import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visited = new boolean[n + 1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(diff, answer);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
            
        }
        
        
        return answer;
    }
    
    static int dfs(int v) {
        visited[v] = true;
        int cnt = 1;
        
        for (int next : graph[v]) {
            if (visited[next]) continue;
            cnt += dfs(next);
        }
        
        return cnt;
    }
}