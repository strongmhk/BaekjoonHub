import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int prime = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            int k = Integer.parseInt(nums[i]);
            for (int j = 1; j <= k; j++) { // 숫자를 1부터 자기 자신까지 나눠주기
               if(k%j == 0) count++;
            }
            if(count == 2) prime++; // 1과 자기 자신의 숫자로만 나누어 떨어지면 소수
        }

        System.out.println(prime);
    }
}