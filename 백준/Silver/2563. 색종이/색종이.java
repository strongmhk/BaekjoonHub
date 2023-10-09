import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] paper = new int[101][101]; // 100x100 좌표 평면을 나타내는 배열

        int n = Integer.parseInt(br.readLine()); // 색종이의 개수
        int area = 0; // 색종이가 붙은 총 넓이

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이를 붙이는 부분을 1로 채우기
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        // 색종이가 붙은 부분을 세어 전체 넓이 구하기
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);

        br.close();
    }
}
