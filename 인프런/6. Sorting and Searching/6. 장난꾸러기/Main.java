import java.io.*;
import java.util.*;

public class Main {
    static String solution(int[] origin) {
        StringBuilder sb = new StringBuilder();

        int[] sorted = origin.clone();
        Arrays.sort(sorted);

        for(int i = 0; i < origin.length; i++) {
            if(origin[i] != sorted[i]) sb.append(i + 1).append(" ");
        }

        return sb.toString();
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