import java.io.*;
import java.util.*;

class Main {
    static int F, S, G, U, D;
    
    static void bfs() {
        boolean[] visited = new boolean[1_000_001];
        int[] count = new int[1_000_001];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(S);
        visited[S] = true;
        
        Arrays.fill(count, 0);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (curr == G) {
                System.out.println(count[curr]);
                return;
            }
            
            int upstairs = curr + U;
            if (upstairs <= F && !visited[upstairs]) {
                queue.add(upstairs);
                visited[upstairs] = true;
                count[upstairs] = count[curr] + 1;
            }
            
            int downstairs = curr - D;
            
            if (downstairs > 0 && !visited[downstairs]) {
                queue.add(downstairs);
                visited[downstairs] = true;
                count[downstairs] = count[curr] + 1;
            }
        }
        
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        bfs();
    }
}