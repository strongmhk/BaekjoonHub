import java.util.*;
import java.io.*;

class Brick implements Comparable<Brick> {
    public int s, h, w;

    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s-this.s;
    }
}

class Main {
    static int[] dy;
    static int solution(ArrayList<Brick> arr) {
        int answer=0;
        Collections.sort(arr);
        dy[0]=arr.get(0).h;
        answer=dy[0];

        for(int i=1; i<arr.size(); i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--){
                if(arr.get(j).w > arr.get(i).w && dy[j]>max_h){
                    max_h=dy[j];
                }
            }
            dy[i]=max_h+arr.get(i).h;
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine(), 10);

        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken(), 10);
            int b = Integer.parseInt(st.nextToken(), 10);
            int c = Integer.parseInt(st.nextToken(), 10);
            arr.add(new Brick(a, b, c));
        }

        System.out.println(solution(arr));
    }
}