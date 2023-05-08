import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 피연산자 개수 입력받기
        char[] postfix = br.readLine().toCharArray(); // 후위 표기식 입력받기

        Map<Character, Double> map = new HashMap<>(); // 피연산자 값 저장할 HashMap선언
        Stack <Double> stack = new Stack<>();

        char key = 'A';
        for(int i = 0; i < N; i++){
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        for(int i = 0; i < postfix.length; i++){
            if(postfix[i] >= 'A' && postfix[i] <= 'Z') stack.push(map.get(postfix[i]));
            else{
                double data1 = stack.pop();
                double data2 = stack.pop();
                if(postfix[i] == '+') stack.push(data2 + data1);
                else if(postfix[i] == '-') stack.push(data2 - data1);
                else if(postfix[i] == '*') stack.push(data2 * data1);
                else if(postfix[i] == '/') stack.push(data2 / data1);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

}
