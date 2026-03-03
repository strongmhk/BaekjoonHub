import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static String[] arr = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        
        DFS("", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
	            answer = i;
	            break;
            }
        }
        
        return answer;
    }
    
    static void DFS(String w, int length) {
        list.add(w);
        if (length == 5) return;
        
        for (int i = 0; i < 5; i++) {
            DFS(w + arr[i], length + 1);
        }
    }
}