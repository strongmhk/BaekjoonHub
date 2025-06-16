import java.util.*;
import java.io.*;

public class Main {
    static String solution(String s1, String s2) {
        String result = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c1 : s1.toCharArray()) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }

        for(char c2 : s2.toCharArray()) {
            if(!map.containsKey(c2) || map.get(c2) == 0) return "NO";
            map.put(c2, map.get(c2) - 1);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }
}