import java.io.*;
import java.util.*;

class Main {
    public int DFS(int n, int r) {
        if (n == r | r == 0) return 1;
        else {
            return DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken(), 10);
        int r = Integer.parseInt(st.nextToken(), 10);

        System.out.println(T.DFS(n, r));
    }
}
