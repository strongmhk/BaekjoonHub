import java.io.*;

public class Main {
    static int solution(int N) {
        int start = 0, sum = 0, count = 0;
        int m = N/2 + 1;
        int[] nums = new int[m];

        for(int i = 0; i < m; i++) nums[i] = i + 1;

        for(int end = 0; end < m; end++) {
            sum += nums[end];
            if(sum == N) count++;
            while(sum >= N) {
                sum -= nums[start++];
                if(sum == N) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);

        System.out.println(solution(N));

    }
}