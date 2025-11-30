import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dis, visit;

    static void BFS(int v) {
        visit[v] = 1;
        dis[v] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)) {
                if (visit[nv] == 0) {
                    visit[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        dis = new int[N+1];
        visit = new int[N+1];

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken(), 10);
            int b = Integer.parseInt(st.nextToken(), 10);
            graph.get(a).add(b);
        }

        dis[1] = 0;
        visit[1] = 1;
        BFS(1);

        for(int i = 2; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}