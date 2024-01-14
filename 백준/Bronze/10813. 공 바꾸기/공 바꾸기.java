import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];

        for (int i = 0; i < N; i++) {
            basket[i] = i + 1;
        }

        for (int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            swap(basket, i, j);

        }

        for (int i = 0; i < N; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);

    }

    private static void swap(int[] basket, int i, int j) {
        int tmp = 0;
        tmp = basket[i-1];
        basket[i-1] = basket[j-1];
        basket[j-1] = tmp;
    }


}

