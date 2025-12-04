import java.util.*;
import java.io.*;

public class Main {
    static String answer = "NO";
    static int N, total = 0;
    static boolean flag = false;

    static void DFS(int L, int sum, int[] arr) {
        if (flag == true) return;
        if (sum > total/2) return;
        if (L == N) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr); 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine(), 10);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(), 10);
            total += arr[i];
        }

        DFS(0, 0, arr);
        System.out.println(answer);
    }
}