import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = blackJack(nums, N, M);


        System.out.println(result);



    }

    private static int blackJack(int[] nums, int N, int M) {
        int result = 0;

        for (int i = 0; i < N-2; i++) {

            if (nums[i] > M) continue;

            for (int j = i+1; j < N-1; j++) {

                if (nums[i] + nums[j] > M) continue;

                for (int k = j+1; k < N; k++) {

                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == M){
                        result = sum;
                    }

                    if (result < sum && sum < M){
                        result = sum;
                    }

                }
            }    
        }

        return result;
    }

}
