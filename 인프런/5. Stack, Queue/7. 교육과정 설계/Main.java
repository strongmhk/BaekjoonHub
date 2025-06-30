import java.util.*;
import java.io.*;

public class Main {
    static String solution(String target, String input) {
        Queue<Character> queue = new LinkedList<>();
        String result = "NO";

        for(char c : target.toCharArray()) queue.offer(c);

        for(char c : input.toCharArray()) {
            if(!queue.isEmpty() && c == queue.peek()) queue.poll();
        }

        if(queue.isEmpty()) result = "YES";

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String input = br.readLine();

        System.out.println(solution(target, input));
    }
}