import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 5;
        int sum = 0;
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        br.close();

        Arrays.sort(nums);

        bw.write(Math.round(sum / N) + "\n" + nums[2]);

        bw.flush();
        bw.close();

    }

}