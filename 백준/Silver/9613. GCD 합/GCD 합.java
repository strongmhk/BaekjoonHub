import java.util.*;


public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }

            long result = 0;
            for (int j = 0; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    result += gcd(arr[j], arr[k]);
                }
            }
            System.out.println(result);
        }
    }
}