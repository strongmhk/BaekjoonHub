import java.util.*;
import java.io.*;

public class Main {
    static int solution(String S, String T) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char c : T.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        for(int i = 0; i < T.length()-1; i++) sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);

        int count = 0, start = 0;

        for(int end = T.length()-1; end < S.length(); end++) {
            sMap.put(S.charAt(end), sMap.getOrDefault(S.charAt(end), 0) + 1);
            if(sMap.equals(tMap)) count++;

            sMap.put(S.charAt(start), sMap.get(S.charAt(start)) - 1);
            if(sMap.get(S.charAt(start)) == 0) sMap.remove(S.charAt(start));

            start++;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        System.out.println(solution(S,T));
    }
}