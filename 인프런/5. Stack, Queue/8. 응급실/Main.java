import java.util.*;
import java.io.*;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    static int solution(int[] arr, int N, int M) {
        int result = 0;
        Queue<Person> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) queue.offer(new Person(i, arr[i]));

        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for(Person p : queue) {
                if(p.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                result++;
                if(tmp.id == M) return result;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken(), 10);
        int M = Integer.parseInt(st.nextToken(), 10);

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(), 10);
        }

        System.out.println(solution(arr, N, M));
    }
}