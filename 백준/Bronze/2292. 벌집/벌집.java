import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 1;
		int sum = 1;
		
		if(N == sum)
			System.out.print(1);
		else {
			while(true)
			{
				if(N <= sum) {
					System.out.print(count);
					break;
				}
				
				sum += count * 6;
				count++;
			}
		}		
	}
}
