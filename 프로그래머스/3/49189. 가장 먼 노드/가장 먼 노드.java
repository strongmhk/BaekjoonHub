import java.util.*;

class Node {
    int num;
    int dis;
    
    public Node (int num, int dis) {
        this.num = num;
        this.dis = dis;
    }
}

class Solution {
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visited;
    static int[] dis;

    public int solution(int n, int[][] vertex) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new boolean[n + 1];
        dis = new int[n + 1];
        Arrays.fill(dis, -1);
        dis[1] = 0;
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 1. 인접리스트를 만든다
        for (int[] connect : vertex) {
            int a = connect[0];
            int b = connect[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 2. BFS 탐색을 통해 1번 노드부터 각 노드까지의 거리를 계산한다.
        BFS(1, graph);
        
        // 3. 거리의 최댓값을 기반으로 최댓값에 충족하는 노드의 개수를 센다.
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dis[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (dis[i] == max) answer++;
        }
        
        return answer;
    }
    
    static void BFS(int start, ArrayList<ArrayList<Integer>> graph) {
        queue.add(new Node(start, 0));
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            ArrayList<Integer> connectedNodes = graph.get(cur.num);
            
            for (int next : connectedNodes) {
                if (visited[next] == true) continue;
                
                queue.add(new Node(next, cur.dis + 1));
                dis[next] = cur.dis + 1;
                
                visited[next] = true;
            }
        }
        
    }
}