import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static int N, M, answer = 0;
    static int[] visit;

    static void DFS(int v) {
        if(v == N) return answer++;
        for(int i = 1; i <= N; i++) {
            if(graph[v][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                DFS(i);
                visit[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        graph = new int[N+1][N+1];
        visit = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken(), 10);
            int b = Integer.parseInt(st.nextToken(), 10);

            graph[a][b] = 1;
        }

        visit[1] = 1;

        DFS(1);
        System.out.println(answer);
    }
}