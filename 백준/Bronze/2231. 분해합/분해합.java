import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int M = 0; // 생성자

        for (int i = 1; i <= N; i++) {
            int num = i; // 각 자리수를 할당할 임시 변수
            int sum = 0; // 각 자리수 합

            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }

            if (sum + i == N) {
                M = i;
                break;
            }
        }

        bw.write(M + "\n");
        bw.close();
    }

}