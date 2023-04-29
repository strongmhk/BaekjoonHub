import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            int small = 0;
            int capital = 0;
            int number = 0;
            int space = 0;
            for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    if (c == ' ') space++;
                    if (c >= '0' && c <= '9') number++;
                    if (c >= 'A' && c <= 'Z') capital++;
                    if (c >= 'a' && c <= 'z') small++;
            }
            System.out.printf("%d %d %d %d\n", small, capital, number, space);
        }
        br.close();
    }
}