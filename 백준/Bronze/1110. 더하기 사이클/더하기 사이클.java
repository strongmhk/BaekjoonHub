import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0, count = 0, number = N, newNumber = 0;

        do{
            sum = (number / 10) + (number % 10);
            newNumber = (number % 10) * 10 + (sum % 10);
            number = newNumber;
            count++;

        } while(number != N);

        System.out.println(count);

    }
}
