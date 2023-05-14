import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nums = line.split(" ");

        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i = 1; i <= n; i++) queue.add(i);

        while(!queue.isEmpty()){
            for(int i = 0; i < k-1; i++) queue.add(queue.poll());
            sb.append(queue.poll());

            if(!queue.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);

    }
}
