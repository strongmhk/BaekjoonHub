import java.io.*;
import java.util.*;

class Main {
    static int N = 0, M = 0;
    static int[] nums, temp, ch;
    static StringBuilder sb = new StringBuilder();

    public void DFS(int depth) {
        if (depth == M) {
            for (int x : temp) {
                sb.append(x).append(" ");
                sb.append("\n");
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    temp[depth] = nums[i];
                    DFS(depth + 1);
                    ch[i] = 0;
                }

            }

        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken(), 10);
        M = Integer.parseInt(st.nextToken(), 10);

        nums = new int[N];
        temp = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken(), 10);

        T.DFS(0);

        System.out.println(sb);
    }
}
