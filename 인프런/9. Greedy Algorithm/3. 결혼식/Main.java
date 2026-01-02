import java.util.*;
import java.io.*;

class Time implements Comparable<Time> {
    public int time;
    public char state;
    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) return this.state - o.state;
        return this.time - o.time;
    }
}

public class Main {
    static int answer = 0;

    public int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int count = 0;

        for (Time t : arr) {
            if(t.state == 's') count++;
            else count--;
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine(), 10);
        ArrayList<Time> arr = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sTime = Integer.parseInt(st.nextToken(), 10);
            int eTime = Integer.parseInt(st.nextToken(), 10);
            arr.add(new Time(sTime, 's'));
            arr.add(new Time(eTime, 'e'));
        }

        System.out.println(T.solution(arr));
    }
}