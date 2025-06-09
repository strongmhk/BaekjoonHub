import java.io.*;
import java.util.*;

public class Main {
    static String solution(int N, int M, int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(p1 < N && p2 < M) {
            if(arr1[p1] == arr2[p2]) {
                sb.append(arr1[p1++]).append(" ");
                p2++;
            } else if(arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }

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