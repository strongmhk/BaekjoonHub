import java.util.*;
import java.io.*;

public class Main {
    static int solution(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        for(int i = 1; i <= N; i++) queue.offer(i);

        while(!queue.isEmpty()) {
            for(int i = 1; i <= K; i++) {
                if(i == K) queue.remove();
                else queue.offer(queue.poll());
            }
            if(queue.size() == 1) result = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int K = Integer.parseInt(st.nextToken(), 10);

        System.out.println(solution(N, K));
    }
}