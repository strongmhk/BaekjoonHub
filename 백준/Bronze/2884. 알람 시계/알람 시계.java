import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m < 45) {
            h--;
            m = 60 - (45 - m);
        }
        else{
            m -= 45;
        }

        sb.append((h + 24) % 24).append(" ").append(m);

        System.out.println(sb);

    }
}