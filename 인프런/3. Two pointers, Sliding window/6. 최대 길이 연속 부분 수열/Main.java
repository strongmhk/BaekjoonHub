import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int K, int[] nums) {
        int start = 0, count = 0, max = 0;

        for(int end = 0; end < N; end++) {
            if(nums[end] == 0) count++;
            while(count > K) {
                if(nums[start] == 0) count--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int K = Integer.parseInt(st.nextToken(), 10);
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, K, nums));
    }
}