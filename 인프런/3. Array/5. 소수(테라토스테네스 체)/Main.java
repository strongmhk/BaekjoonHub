import java.io.*;

public class Main {
    static int solution(int N) {
        int count = 0;
        int[] ch = new int[N + 1];

        for(int i = 2; i <= N; i++) {
            if(ch[i] == 0) {
                count++;
                for(int j = i; j <= N; j = j + i) ch[j] = 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}