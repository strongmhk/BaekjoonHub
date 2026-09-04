import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        Set<String> keys = new HashSet<>();
        
        int intersection = 0;
        int union = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 두글자 단위로 쪼개서 알파벳만 넣는다.
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            
            if (isAlphabet(c1) && isAlphabet(c2)) {
                String word = str1.substring(i, i + 2);
                mapA.put(word, mapA.getOrDefault(word, 0) + 1);
                
                keys.add(word);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            
            if (isAlphabet(c1) && isAlphabet(c2)) {
                String word = str2.substring(i, i + 2);
                mapB.put(word, mapB.getOrDefault(word, 0) + 1);
                
                keys.add(word);
            }
        }
        
        // 합집합, 교집합 계산
        for (String key : keys) {
            int countA = mapA.getOrDefault(key, 0);
            int countB = mapB.getOrDefault(key, 0);

            intersection += Math.min(countA, countB);
            union += Math.max(countA, countB);
        }
        
        if (union == 0) return 65536;
        
        double similarity = (double) intersection / union;
        
        return (int) (similarity * 65536);
    }
    
    static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z');
    }
}

// 두글자 단위로 쪼갠다. -> Map에 글자 : count 형태로 저장한다
// 교집합과 합집합을 계산한다.