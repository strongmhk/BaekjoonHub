import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    /**
     * 매개변수(str)의 문자열이 팰린드롬인지 검사
     * 팰린드롬이란 앞에서 읽으나 뒤에서 읽으나 동일한 문자
     * ex) level
     */
    public static int isPalindrom(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();

        return str.equals(reversed) ? 1 : 0;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.println(isPalindrom(str));
    }
}