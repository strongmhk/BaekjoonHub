import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int M = Integer.parseInt(st.nextToken(), 10);
        int dy[] = new int[M + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());

            for(int j = M; j >= pt ; j--) {
                dy[j]=Math.max(dy[j], dy[j-pt]+ps);
            }
        }

        System.out.println(dy[M]);

    }
}