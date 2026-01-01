import java.util.*;
import java.io.*;


class Meeting implements Comparable<Meeting> {
    public int s, e;
    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if (o.e != this.e) {
            return this.e - o.e;
        }
        return this.s - o.s;
    }
}

class Main {
    static ArrayList<Meeting> meetings;
    static int answer;

    public int solution() {
        Collections.sort(meetings);

        int prevEndTime = 0;
        for(Meeting m : meetings) {
            if (m.s >= prevEndTime) {
                answer++;
                prevEndTime = m.e;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        meetings = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken(), 10);
            int end = Integer.parseInt(st.nextToken(), 10);
            meetings.add(new Meeting(start, end));
        }

        System.out.println(T.solution());
    }
}