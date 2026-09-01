import java.util.*;

class Solution {
    static List<String> wordList;
    static String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        wordList = new ArrayList<>();
        dfs("", 0);
        
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    // 모든 단어 생성
    static void dfs(String str, int length) {
        wordList.add(str);
        if (length == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], length + 1);
        }
    }
}
