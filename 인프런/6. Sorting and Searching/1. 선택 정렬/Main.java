import java.util.*;
import java.io.*;

public class Main {
    static int[] solution(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++) {
            // 최솟값 찾기
            int minIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) minIdx = j;
            }

            // swap
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
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