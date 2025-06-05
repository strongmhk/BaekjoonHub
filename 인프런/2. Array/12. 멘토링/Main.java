import java.util.*;
import java.io.*;

public class Main {
    static int solution(int M, int N, int[][] grades) {
        int count, result = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (i == j) continue;
                count = 0;
                for(int k = 0; k < M; k++) {
                    int rankA = 0, rankB = 0;
                    for(int s = 0; s < N; s++) {
                        if(grades[k][s] == i) rankA = s;
                        if(grades[k][s] == j) rankB = s;
                    }
                    if(rankA < rankB) count++;
                }
                if(count == M) result++;
            }

        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int M = Integer.parseInt(st.nextToken(), 10);

        int[][] grades = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                grades[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }

        System.out.println(solution(M, N, grades));
    }
}