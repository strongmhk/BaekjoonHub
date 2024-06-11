import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // F 입력 받기
        int F = Integer.parseInt(br.readLine());
        
        // N을 100으로 나눈 몫을 구하기
        int quotient = N / 100;
        
        // 마지막 두 자리 수 찾기
        int lastTwoDigits = 0;
        for (int i = 0; i < 100; i++) {
            if ((quotient * 100 + i) % F == 0) {
                lastTwoDigits = i;
                break;
            }
        }
        
        // 결과 출력
        if (lastTwoDigits < 10) {
            bw.write("0" + lastTwoDigits);
        } else {
            bw.write(String.valueOf(lastTwoDigits));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
