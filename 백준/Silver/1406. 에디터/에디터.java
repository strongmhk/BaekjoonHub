import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initialString = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char ch : initialString.toCharArray()) {
            leftStack.push(ch);
        }

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char operation = command.charAt(0);

            if (operation == 'L') {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (operation == 'D') {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (operation == 'B') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (operation == 'P') {
                char ch = command.charAt(2);
                leftStack.push(ch);
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder result = new StringBuilder();
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.println(result.toString());
    }
}
