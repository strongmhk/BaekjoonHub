import java.io.*;
import java.util.*;

class Main {
    static int N = 0, M = 0;
    static int[] combi;

    public void DFS(int L, int s) {
        if (L == M) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = s; i <= N; i++) {
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
        combi = new int[M];

        T.DFS(0, 1);
    }
}