import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수의 개수

        Deque<Integer> deque = new ArrayDeque<>();

        // 큐 초기화
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        // 뽑아내려는 수들을 차례로 처리
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 뽑아내려는 수가 큐의 가장 왼쪽에 위치할 때까지 수행
            while (true) {
                if (deque.peekFirst() == target) {
                    deque.pollFirst();
                    break;
                } else {
                    // 왼쪽으로 한 칸 이동
                    if (getIndex(deque, target) <= deque.size() / 2) {
                        deque.offerLast(deque.pollFirst());
                    }
                    // 오른쪽으로 한 칸 이동
                    else {
                        deque.offerFirst(deque.pollLast());
                    }
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    // 덱 안의 원소의 인덱스 가져오기
    private static int getIndex(Deque<Integer> deque, int target) {
        int index = 0;
        for (int num : deque) {
            if (num == target) {
                return index;
            }
            index++;
        }
        return -1; // 원소 찾기 실패
    }
}
