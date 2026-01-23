import java.io.*;
import java.util.*;

class Main {
    static void bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] commands = new String[10000];
        
        queue.add(a);
        visited[a] = true;
        Arrays.fill(commands, "");
        
        while(!queue.isEmpty() && !visited[b]) {
            int current = queue.poll();
            
            int D = (2 * current) % 10000;
            int S = (current == 0) ? 9999 : current - 1;
            int L = (current % 1000) * 10 + (current / 1000);
            int R = (current % 10) * 1000 + (current / 10);
            
            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                commands[D] = commands[current] + 'D';
            }
            
            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                commands[S] = commands[current] + 'S';
            }
            
            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                commands[L] = commands[current] + 'L';
            }
            
            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                commands[R] = commands[current] + 'R';
            }
        }
        
        System.out.println(commands[b]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bfs(A, B);
        }
        
    }
}
