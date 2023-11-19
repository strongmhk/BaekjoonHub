import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < T; i++) {
            sb.append(isVPS(br.readLine())).append('\n');

        }

        System.out.println(sb);

    }

    public static String isVPS(String ps) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ps.length(); i++) {

            char c = ps.charAt(i);

            // 여는 괄호일 경우
            if (c == '(') {
                stack.push(c);
            }

            // 아래는 모두 닫는 괄호일 경우

            // 닫는 괄호를 입력 받았으나 스택이 비어있는 경우
            else if (stack.empty()) {
                return "NO";
            }
            // 그 외의 경우
            else {
                stack.pop();
            }
        }

         /*
         모든 검사 마치고 여는 괄호가 많은 경우는 "NO"
         스택이 비어있으면 "YES"
         */

        if (stack.empty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}

}
