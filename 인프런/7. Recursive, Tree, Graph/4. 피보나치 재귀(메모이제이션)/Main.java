import java.io.*;
import java.util.*;

class Main {
    static int[] fibo;

    static int fibonacci(int N) {
        if (fibo[N] > 0) return fibo[N];
        if (N == 1 || N == 2) return fibo[N] = 1;
        else return fibo[N] = fibonacci(N - 1) + fibonacci(N - 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fibo = new int[N + 1];
        fibonacci(N);

        for (int i = 1; i <= N; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}