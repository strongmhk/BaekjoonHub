import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        
        br.close();
        
        int third = num1 * (num2 % 10);
        int fourth = num1 * ((num2 % 100) / 10);
        int fifth = num1 * (num2 / 100);
        int sixth = third + fourth * 10 + fifth * 100;

        sb.append(third).append('\n');
        sb.append(fourth).append('\n');
        sb.append(fifth).append('\n');
        sb.append(sixth).append('\n');

        System.out.println(sb);

    }
}