import java.util.*;
import java.io.*;

public class Main {
    static String solution(int N, int K, int[] arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < K-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int start = 0;

        for(int end = K-1; end < N; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            sb.append(map.size()).append(" ");

            map.put(arr[start], map.get(arr[start]) - 1);
            if(map.get(arr[start]) == 0) map.remove(arr[start]);
            start++;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int K = Integer.parseInt(st.nextToken(), 10);

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, K, arr));
    }
}