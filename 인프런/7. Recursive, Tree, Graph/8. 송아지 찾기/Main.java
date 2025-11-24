import java.io.*;
import java.util.*;

class Main {
    static int BFS(int s, int e) {
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[s] = 1;
        int level = 0;

        while(!queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i <= length; i++) {
                int x = queue.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx == e) return level + 1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }

            level++;
        }

        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken(), 10);
        int e = Integer.parseInt(st.nextToken(), 10);

        System.out.println(BFS(s, e));
    }
}