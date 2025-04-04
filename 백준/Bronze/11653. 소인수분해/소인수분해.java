import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        br.close();
        
        while(N != 1) {
            for(int i = 2; i <= N; i++) {
                if(N % i == 0) {
                    System.out.println(i);
                    N /= i;
                    break;
                }
            }
        }
    }
}