import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    static String solution(int[] arr, int N) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            int res = 0;

            while(tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if(isPrime(res)) sb.append(res).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr, N));
    }
}