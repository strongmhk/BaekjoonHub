import java.util.*;
import java.io.*;

public class Main {
    static String solution(int N, int M, int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 < N && p2 < M) {
            if(arr1[p1] < arr2[p2]) sb.append(arr1[p1++]).append(" ");
            else sb.append(arr2[p2++]).append(" ");
        }

        while(p1 < N) sb.append(arr1[p1++]).append(" ");
        while(p2 < M) sb.append(arr2[p2++]).append(" ");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken(), 10);
        }

        int M = Integer.parseInt(br.readLine(), 10);
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, M, arr1, arr2));

    }
}