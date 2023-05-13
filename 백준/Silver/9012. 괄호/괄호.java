import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int balance = 0; // n1 : '('의 개수, ')'의 개수
            String ps = br.readLine();
            for(int j = 0; j < ps.length(); j++){
                if(ps.charAt(j) == '(') balance++;
                if(ps.charAt(j) == ')') {
                    balance--;
                    if(balance < 0) break;
                }

            }

            if(balance == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}