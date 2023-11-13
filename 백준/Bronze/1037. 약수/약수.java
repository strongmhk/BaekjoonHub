import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] divisor = new int[N];
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            divisor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisor);

        max = divisor[N-1];
        min = divisor[0];

        System.out.println(max*min);

    }
}