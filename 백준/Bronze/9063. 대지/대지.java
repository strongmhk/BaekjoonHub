import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(x);
        Arrays.sort(y);
        
        System.out.println(calcArea(N, x, y));
    }
    
    static int calcArea(int N, int[] x, int[] y) {
        return (x[N-1] - x[0]) * (y[N-1] - y[0]);
    }
}