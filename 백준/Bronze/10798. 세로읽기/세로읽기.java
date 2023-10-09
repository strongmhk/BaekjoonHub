import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 라인을 읽어와 배열에 저장
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
        }

        // 문자를 세로로 정렬
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < lines[j].length()) {
                    sb.append(lines[j].charAt(i));
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
