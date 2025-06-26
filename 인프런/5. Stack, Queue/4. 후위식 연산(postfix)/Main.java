import java.io.*;
import java.util.*;

public class Main {
    static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) stack.push(c - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+') stack.push(lt + rt);
                else if(c == '-') stack.push(lt - rt);
                else if(c == '*') stack.push(lt * rt);
                else if(c == '/') stack.push(lt / rt);

            }
        }

        result = stack.get(0);

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }
}