import java.io.*;
import java.util.*;

class Main {
    static int[] dy;
    static int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;

        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(dy[i], answer);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];


        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(arr));
    }
}