import java.util.*;
import java.io.*;

public class Main {
    static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if(s.charAt(i-1) == '(') count += stack.size();
                else count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}