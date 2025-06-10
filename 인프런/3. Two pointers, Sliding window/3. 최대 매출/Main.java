import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int K, int[] sales) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < K; i++) {
            sum += sales[i];
        }

        max = sum;

        for(int i = K; i < N; i++) {
            sum += (sales[i] - sales[i-K]);
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int K = Integer.parseInt(st.nextToken(), 10);

        int[] sales = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            sales[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, K, sales));

    }
}