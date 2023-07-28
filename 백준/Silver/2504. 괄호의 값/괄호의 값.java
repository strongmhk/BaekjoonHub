import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = calculate(input);

        System.out.println(result);
    }

    public static int calculate(String input) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int result = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else if (c == '[') {
                stack.push(-2);
            } else if (c == ')') {
                current = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    current += stack.pop();
                }
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop(); // Remove the '('
                stack.push(current == 0 ? 2 : current * 2);
            } else if (c == ']') {
                current = 0;
                while (!stack.isEmpty() && stack.peek() != -2) {
                    current += stack.pop();
                }
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop(); // Remove the '['
                stack.push(current == 0 ? 3 : current * 3);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() < 0) {
                return 0;
            }
            result += stack.pop();
        }

        return result;
    }
}

