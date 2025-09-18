import java.io.*;
import java.util.*;

public class Main {
    static String solution(int S, int N, int[] tasks) {
        int[] cache = new int[S];
        StringBuilder sb = new StringBuilder();

        for(int x : tasks) {
            int pos = -1;

            // 캐시 안에 원소가 있으면 원소 위치 저장
            for(int i = 0; i < S; i++) if(x == cache[i]) pos = i;

            // 캐시 안에 없을 때
            if(pos == -1) {
                // 맨 처음부터 마지막 바로 앞 까지의 원소들을 한 칸씩 뒤로 옮기기
                for(int i = S - 1; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            // 캐시 안에 있을 때
            else {
                // 맨 처음부터 pos 이전까지의 원소들을 한 칸씩 뒤로 옮기기
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }

            // 캐시 메모리 맨 앞에 삽입
            cache[0] = x;
        }

        for(int i = 0; i < S; i++) sb.append(cache[i]).append(" ");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] tasks = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) tasks[i] = Integer.parseInt(st.nextToken(), 10);

        System.out.println(solution(S, N, tasks));

    }

}