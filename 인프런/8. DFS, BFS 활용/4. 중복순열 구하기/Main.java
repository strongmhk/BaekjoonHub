import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int N = 0, M = 0;
    static StringBuilder sb = new StringBuilder();

    public void DFS(int depth) {
        if (depth == M) {
            for(int x : arr) sb.append(x).append(" ");
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                arr[depth] = i;
                DFS(depth + 1);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        arr = new int[N];

        T.DFS(0);
        System.out.println(sb);
    }
}