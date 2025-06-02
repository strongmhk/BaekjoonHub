import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int[] grades) {
        int sum = 0;
        int grade = 0;

        for(int i = 0; i < N; i++) {
            if(grades[i] == 1) {
                grade++;
                sum += grade;
            } else {
                grade = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] grades = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, grades));
    }
}