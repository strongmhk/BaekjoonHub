import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll(); // 맨 위의 원소 삭제
            queue.offer(queue.poll()); // 맨 위(맨 앞)의 원소 삭제한 후 맨 아래(맨 뒤)로 넣기
        }

        System.out.println(queue.peek());


    }
}