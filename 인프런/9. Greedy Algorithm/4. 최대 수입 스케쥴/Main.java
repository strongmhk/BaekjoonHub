import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int fee, deadLine;

    public Lecture(int fee, int deadLine) {
        this.fee = fee;
        this.deadLine = deadLine;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.deadLine - this.deadLine;
    }
}

class Main {
    static int max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr, int N) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int j = 0; // 넣었던 강의를 다시 큐에 넣는 것을 방지
        for (int i = max; i >= 1; i--) {
            for (; j < N; j++) {
                if (arr.get(j).deadLine < i) break;
                queue.offer(arr.get(j).fee);
            }

            if (!queue.isEmpty()) answer += queue.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        StringTokenizer st;
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken(), 10);
            int D = Integer.parseInt(st.nextToken(), 10);
            arr.add(new Lecture(M, D));
            if (D > max) max = D;
        }

        System.out.println(T.solution(arr, N));
    }

}