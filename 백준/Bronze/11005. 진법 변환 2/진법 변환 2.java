import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        br.close();

        StringBuilder sb = new StringBuilder();
        
        while(N > 0) {
            int remainder = N % B;
            if(remainder < 10) {
                sb.append((char)(remainder + '0'));
            } else {
                sb.append((char)(remainder - 10 + 'A'));
            }
            N /= B;
        }
        
        System.out.println(sb.reverse());
    }
    
}