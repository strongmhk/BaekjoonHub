import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];


        // 좌표 2차원 배열에 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2차원 배열 정렬 (첫번째 기준은 y)
        Arrays.sort(nums, (num1, num2) -> {
            return num1[1]!=num2[1] ? num1[1]-num2[1] : num1[0]-num2[0];
        });


        for(int i = 0; i < N; i++){
            bw.write(nums[i][0] + " " + nums[i][1] +"\n");
        }

        bw.flush();


    }
}