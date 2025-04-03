import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean exist = false;
        
        for(int i = M; i <= N; i++) {
            if (i == 1) {
                continue;
            }
            
            for(int j = 2; j <= i; j++) {
                if(i == j) {
                    min = (min > j) ? j : min;
                    sum += j;
                    exist = true;
                }
                if(i % j == 0) break;
            }
        }
        
        if(exist == true) {
            System.out.println(sum);
            System.out.println(min);    
        } else {
            System.out.println(-1);
        }
    }
}