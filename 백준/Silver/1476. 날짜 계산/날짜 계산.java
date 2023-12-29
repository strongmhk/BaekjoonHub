import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // input
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 0, s = 0, m = 0; // 계산용
        int year = 0; // 실제 년도

        while (true) {

            year++;
            e++;
            s++;
            m++;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;

            if ((e == E) && (s == S) && (m == M)) break;

        }
        System.out.println(year);

    }
}