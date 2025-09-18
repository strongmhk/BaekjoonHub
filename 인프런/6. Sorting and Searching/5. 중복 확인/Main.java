import java.io.*;
import java.util.*;

public class Main {
    static char solution(int[] arr) {
        char result = 'U';

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                result = 'D';
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken(), 10);

        System.out.println(solution(arr));
    }

}