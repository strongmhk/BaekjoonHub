import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, Comparator.comparingInt(o -> o[0])); 

        int[] dp = new int[N];
        Arrays.fill(dp, 1); 

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[j][1] < lines[i][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Arrays.stream(dp).max().orElse(0); 
        int answer = N - max; 

        System.out.println(answer);
    }
}
