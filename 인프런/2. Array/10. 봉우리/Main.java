import java.io.*;
import java.util.*;

public class Main {
    static int solution(int N, int[][] heights) {
        int[] rowVector = {-1, 0, 1, 0};
        int[] colVector = {0, 1, 0, -1};
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + rowVector[k];
                    int ny = j + colVector[k];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && heights[nx][ny] >= heights[i][j]) {
                        flag = false;
                    }
                }
                if(flag) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);
        StringTokenizer st;

        int[][] heights = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }

        System.out.println(solution(N, heights));
    }
}