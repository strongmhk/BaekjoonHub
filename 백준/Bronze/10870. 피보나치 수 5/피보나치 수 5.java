import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] Fibo = new int[n+1]; // 피보나치 수열은 0번째부터 시작하므로 n+1 크기의 배열 생성
        for (int i = 0; i <= n; i++) {
            if(i <= 1) Fibo[i] = i; // F[0] = 0, F[1] = 1
            else Fibo[i] =  Fibo[i-1] + Fibo[i-2]; // i >= 2일 때, F(i) = F(i-1) + F(i-2)
        }
        System.out.println(Fibo[n]);

    }
}