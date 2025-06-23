import java.util.*;
import java.io.*;

public class Main {
    static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(');
            } else stack.push(c);
        }

        for(int i = 0; i < stack.size(); i++) sb.append(stack.get(i));

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(solution(s));
    }
}