import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            for (int l = i; l <= j; l++) {
                int n = j--;

                swap(basket, l, n);
            }

        }

        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);


    }

    private static void swap(int[] basket, int i, int j) {
        int tmp = basket[j];
        basket[j] = basket[i];
        basket[i] = tmp;
    }
}

