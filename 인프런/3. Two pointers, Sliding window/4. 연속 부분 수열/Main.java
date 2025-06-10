import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int M, int[] data) {
        int start = 0, count = 0, intervalSum = 0;

        for(int end = 0; end < N; end++) {
            intervalSum += data[end];
            if(intervalSum == M) count++;
            while(intervalSum >= M) {
                intervalSum -= data[start++];
                if(intervalSum == M) count++;
            }
        }

        return count;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int M = Integer.parseInt(st.nextToken(), 10);

        int[] data = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, M, data));
    }
}