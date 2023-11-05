import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        int sum = 0;

        for (int i = 0; i < K; i++) {
            num = Integer.parseInt(br.readLine());
            if (num != 0) stack.push(num);
            else stack.pop();
        }

        while (!stack.empty()){
            sum += stack.pop();
        }

        System.out.println(sum);


    }
}