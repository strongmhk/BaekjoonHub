import java.util.*;
import java.io.*;

public class Main {
    static String solution(int N, int[] grades) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(grades[i] < grades[j]) rank++;
            }
            sb.append(rank).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);
        int[] grades = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(N, grades));
    }
}