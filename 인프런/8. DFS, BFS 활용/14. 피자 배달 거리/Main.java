import java.util.*;
import java.io.*;

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N = 0, M = 0, len = 0, answer = Integer.MAX_VALUE;
    static ArrayList<Point> hs, pz;
    static int[] combi;

    public void DFS(int L, int s) {
        // 피자 집의 조합이 구해졌을 때
        if (L == M) {
            int sum = 0;

            // 각 집의 피자 배달 거리 구해서 합하기
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            // 도시의 피자 배달 거리중 최소값 구하기
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        hs = new ArrayList<>();
        pz = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken(), 10);
                if (tmp == 1) hs.add(new Point(i, j));
                else if (tmp == 2) pz.add(new Point(i, j));
            }
        }

        len = pz.size();
        combi = new int[M];
        T.DFS(0, 0);

        System.out.println(answer);
    }
}