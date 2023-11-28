import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 문자열을 읽기
        String input = br.readLine().trim();

        // 모든 접미사를 저장할 배열 생성
        String[] suffixes = new String[input.length()];

        // 모든 접미사 생성
        for (int i = 0; i < input.length(); i++) {
            suffixes[i] = input.substring(i);
        }

        // 접미사를 사전순으로 정렬
        Arrays.sort(suffixes);

        // 정렬된 접미사 출력
        for (String suffix : suffixes) {
            System.out.println(suffix);
        }

       
    }
}
