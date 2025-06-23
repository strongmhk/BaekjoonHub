import java.util.*;
import java.io.*;

public class Main {
    static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "YES";

        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}