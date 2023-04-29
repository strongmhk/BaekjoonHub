import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder str = new StringBuilder("");
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int num = (int)ch;
            if((num >= 65 && num <= 77) || (num >= 97 && num <= 109)) ch = (char)(num + 13);
            if((num >= 78 && num <= 90) || (num >= 110 && num <= 122)) ch = (char)(num - 13);
            str.append(ch);
        }
        System.out.println(str);
    }
}
