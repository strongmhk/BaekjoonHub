import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int pay, day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

class Main {
    static int max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr, int N) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < N; j++) {
                if (arr.get(j).day < i) break;
                queue.offer(arr.get(j).pay);
            }

            if (!queue.isEmpty()) answer += queue.poll();
        }

        return answer;
    }
    
    public static void main(String[] args) throws Exception {
        Main T = new Main();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Lecture(p, d));
            max = Math.max(max, d);
        }

        System.out.println(T.solution(arr, N));
    }
}