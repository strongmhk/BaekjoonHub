import java.io.*;
import java.util.*;

class Main {
    static int N = 0, M = 0, max = Integer.MIN_VALUE;

    public void DFS(int L, int scoreSum, int timeSum, int[][] arr) {
        if (timeSum > M) return;
        if (L == N) {
            max = Math.max(scoreSum, max);
        } else {
            DFS(L + 1, scoreSum + arr[L][0], timeSum + arr[L][1], arr);
            DFS(L + 1, scoreSum, timeSum, arr);
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken(), 10);
            arr[i][1] = Integer.parseInt(st.nextToken(), 10);
        }

        T.DFS(0, 0, 0, arr);

        System.out.println(max);
    }
}