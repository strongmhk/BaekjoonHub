import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int n = Integer.parseInt(br.readLine());    
            
            if(n == -1) {
                break;
            }
            
            int[] divisors = new int[n];
            int sum = 0;
        
            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    divisors[i] = i;
                    sum += i;
                }
            }
            
            if(sum != n) {
                sb.append(n + " is NOT perfect.\n");
                continue;
            } else {
                sb.append(n + " = 1");
                
                for(int i = 2; i < n; i++) {
                    if(divisors[i] != 0) {
                        sb.append(" + " + divisors[i]);
                    }
                }
            }
            
            sb.append("\n");
        }
        
        br.close();
        System.out.println(sb);   
    }
}