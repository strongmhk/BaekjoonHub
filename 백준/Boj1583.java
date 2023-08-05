import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine(); 
        String pattern = br.readLine();

        int[] failure = computeFailure(pattern);

        int count = kmpSearch(text, pattern, failure);
        System.out.println(count);
    }

    
    private static int[] computeFailure(String pattern) {
        int[] failure = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = failure[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                failure[i] = ++j;
            }
        }

        return failure;
    }

   
    private static int kmpSearch(String text, String pattern, int[] failure) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = failure[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    count++;
                    j = failure[j];
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
