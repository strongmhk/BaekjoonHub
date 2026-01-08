import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Main {
    static int N = 0, M = 0;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;

        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) continue;
            for (Edge o : graph.get(now)) {
                if (dis[o.vex] > nowCost + o.cost) {
                    dis[o.vex] = nowCost + o.cost;
                    pQ.offer(new Edge(o.vex, nowCost + o.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
        }

        T.solution(1);
        for (int i = 2; i <= N; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }

    }
}