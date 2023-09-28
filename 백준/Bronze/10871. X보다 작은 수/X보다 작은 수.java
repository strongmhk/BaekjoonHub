import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (nums[i] < X) sb.append(nums[i]).append(' ');
        }

        System.out.println(sb);

    }
}