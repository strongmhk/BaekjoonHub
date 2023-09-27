import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b;
        StringTokenizer st;

        String str;

        StringBuilder sb = new StringBuilder();

        while ((str= br.readLine()) != null){
            st = new StringTokenizer(str, " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(a+b).append('\n');
        }

        System.out.println(sb);


    }
}