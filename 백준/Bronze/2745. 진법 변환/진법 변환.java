import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int sum = 0;
        int tmp = 1;

        for (int i = N.length() - 1; i >= 0; i--) {
            char C = N.charAt(i);
            if ('0' <= C && C <= '9') {
                sum += (C - '0') * tmp;
            } else {
                sum += (C - 'A' + 10) * tmp;
            }
            tmp *= B;
        }

        System.out.println(sum);

    }
}