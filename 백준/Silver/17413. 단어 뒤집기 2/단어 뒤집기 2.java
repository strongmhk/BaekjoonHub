import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();

        boolean isTag = false;  // 태그 안인지 여부를 판단하는 변수

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                // '<'를 만나면 태그 시작
                printStack(stack, sb);  // 스택에 저장된 문자들 출력
                isTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                // '>'를 만나면 태그 종료
                isTag = false;
                sb.append(ch);
            } else if (isTag) {
                // 태그 안에 있는 경우 문자 그대로 추가
                sb.append(ch);
            } else {
                // 태그 밖에 있는 경우 단어 뒤집기
                if (ch == ' ') {
                    // 공백을 만나면 스택에 저장된 문자들 출력 후 공백 추가
                    printStack(stack, sb);
                    sb.append(ch);
                } else {
                    // 스택에 문자 추가
                    stack.push(ch);
                }
            }
        }

        // 마지막으로 스택에 남아있는 문자들 출력
        printStack(stack, sb);

        System.out.println(sb.toString());
    }

    // 스택에 저장된 문자들을 출력하고 스택 비우기
    private static void printStack(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}