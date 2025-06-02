import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int[][] arr) {
        int rowSum = 0, colSum = 0, crossSum1 = 0, crossSum2 = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            rowSum = 0; colSum = 0;
            for(int j = 0; j < N; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }

            max = Math.max(max, rowSum);
            max = Math.max(max, colSum);
        }

        for(int i = 0; i < N; i++) {
            crossSum1 += arr[i][i];
            crossSum2 += arr[N-1-i][i];
        }

        max = Math.max(max, crossSum1);
        max = Math.max(max, crossSum2);

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);
        int[][] arr = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }

        System.out.println(solution(N, arr));
    }
}