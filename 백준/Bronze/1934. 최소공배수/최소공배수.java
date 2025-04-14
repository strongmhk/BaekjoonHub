import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lcm(a, b));

		}

	}

	private static int gcd(int a, int b) {
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		int r = a % b;
		if (r == 0) {
			return b;
		}
		return gcd(b, r);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

}