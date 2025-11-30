import java.io.*;
import java.util.*;

// N : 노드 개수, M : 간선의 개수
// visit[v] : 정점 v를 이미 방문했는지 여부

class Main {
    static int N, M, answer = 0;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> graph;

    static void DFS(int v) {
        if (v == N) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (visit[nv] == 0) {
                    visit[nv] = 1;
                    DFS(nv);
                    visit[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new int[N+1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <= N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken(), 10);
            int b = Integer.parseInt(st.nextToken(), 10);

            graph.get(a).add(b);
        }

        visit[1] = 1;
        DFS(1);

        System.out.println(answer);
    }
}