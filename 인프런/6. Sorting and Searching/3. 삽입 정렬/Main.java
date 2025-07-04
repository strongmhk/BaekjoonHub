import java.util.*;
import java.io.*;

public class Main {
    static int[] solution(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for(j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }

            arr[j + 1] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(), 10);
        }

        for(int n : solution(arr)) {
            System.out.print(n + " ");
        }

    }
}