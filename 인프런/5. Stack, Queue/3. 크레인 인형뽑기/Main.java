import java.util.*;
import java.io.*;

public class Main {
    static int solution(int[][] boards, int[] moves, int N, int M) {
        Stack<Integer> stack = new Stack<>();
        int count = 0, col = 0;

        for(int i = 0; i < M; i++) {
            col = moves[i] - 1;

            for(int j = 0; j < N; j++) {
                if(boards[j][col] != 0) {
                    if(!stack.isEmpty() && stack.peek() == boards[j][col]) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(boards[j][col]);
                    }
                    boards[j][col] = 0;
                    break;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        int[][] boards = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken(), 10);
            }
        }

        int M = Integer.parseInt(br.readLine(), 10);
        int[] moves = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(boards, moves, N, M));
    }
}