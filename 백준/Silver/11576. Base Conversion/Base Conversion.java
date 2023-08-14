import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int decimal = 0;
        
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(nums[i]);
            decimal = decimal * A + num;
        }

        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % B);
            decimal /= B;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
