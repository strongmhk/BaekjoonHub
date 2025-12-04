import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int N = 0, C = 0;

    public void DFS(int L, int sum, int[] arr) {
        if(sum > C) return;
        if(L == N) {
            max = Math.max(sum, max);
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken(), 10);
        N = Integer.parseInt(st.nextToken(), 10);

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine(), 10);

        main.DFS(0, 0, arr);

        System.out.println(max);
    }
}