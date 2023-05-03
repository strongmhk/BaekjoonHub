import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        String s = br.readLine();
        
        for(int i = 0; i < s.length(); i++) count[s.charAt(i) - 97]++;
        for(int i = 0; i < count.length; i++) System.out.printf("%d ", count[i]);
    }
}