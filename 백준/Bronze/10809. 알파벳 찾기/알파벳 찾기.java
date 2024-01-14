import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(s.indexOf(ch)).append(" ");
        }

        System.out.println(sb);

        br.close();

    }


}

