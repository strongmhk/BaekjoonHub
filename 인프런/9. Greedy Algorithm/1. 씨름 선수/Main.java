import java.util.*;
import java.io.*;

class Body implements Comparable<Body> {
    public int h, w;
    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}

class Main {
    public int solution(ArrayList<Body> arr) {
        Collections.sort(arr);
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(Body b : arr) {
            if (b.w > max) {
                max = b.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        ArrayList<Body> arr = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(st.nextToken(), 10);
            int weight = Integer.parseInt(st.nextToken(), 10);
            arr.add(new Body(height, weight));
        }

        System.out.println(T.solution(arr));
    }
}