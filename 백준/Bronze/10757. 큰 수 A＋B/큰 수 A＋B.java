import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();
        
        String A = st.nextToken();
        String B = st.nextToken();

        int flag = 0; 

        for(int i = A.length() - 1, j = B.length() - 1; i >= 0 || j >= 0; i--, j--){
            int num = flag;

            if(i >= 0) num += A.charAt(i) - '0';

            if(j >= 0) num += B.charAt(j) - '0';

            if(num < 10){ 
                flag = 0;
            } else { 
                flag = 1;
                num -= 10;
            }

            sb.append(num);
        }

        if(flag == 1) sb.append(1);

        System.out.println(sb.reverse()); 
    }
}