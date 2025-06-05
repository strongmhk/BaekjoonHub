import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int[][] arr) {
        int max = 0, result = 0;

        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(count > max) {
                max = count;
                result = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        int[][] arr = new int[N][5];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }

        System.out.println(solution(N, arr));

    }
}