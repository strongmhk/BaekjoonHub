import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for (char c : s.toCharArray()) {
            int count = 0;
            char current = c;
            
            while (count < index) {
                // 현재 문자가 z이면 a로 변환
                if (current == 'z') current = 'a';
                else current++;
                
                if (skipSet.contains(current)) continue;
                
                count++;
            }
            
            sb.append(current);
        }
        
        return sb.toString();
    }
}