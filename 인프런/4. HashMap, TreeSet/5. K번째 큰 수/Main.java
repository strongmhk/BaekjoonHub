import java.util.*;
import java.io.*;

public class Main {
    static int solution(int[] arr, int N, int K) {
        int result = -1;
        TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int l = j + 1; l < N; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int count = 0;

        for(int num : set) {
            count++;
            if(count == K) return num;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int K = Integer.parseInt(st.nextToken(), 10);

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken(), 10);

        System.out.println(solution(arr, N, K));

    }
}