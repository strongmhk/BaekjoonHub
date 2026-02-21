import java.util.*;

class Distance {
    public String word;
    public int dis;
    
    public Distance(String word, int dis) {
        this.word = word;
        this.dis = dis;
    }
}

class Solution {
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = BFS(begin, target, words);
        
        return answer;
    }
    
    static int BFS(String begin, String target, String[] words) {
        int n = words.length;
        
        Queue<Distance> queue = new LinkedList<>();
        visited = new boolean[n];
        
        queue.offer(new Distance(begin, 0));
        
        while (!queue.isEmpty()) {
            Distance cur = queue.poll();
            
            for (int i = 0; i < n; i++) {
                if (visited[i] == true || isNext(cur.word, words[i]) == false) continue;
                
                if (words[i].equals(target)) return cur.dis + 1;
                
                queue.offer(new Distance(words[i], cur.dis + 1));
                visited[i] = true;
            }
        }
        
        return 0;
    }
    
    static boolean isNext(String curWord, String nextWord) {
        int count = 0;
        int len = curWord.length();
        
        for (int i = 0; i < len; i++) {
            if (curWord.charAt(i) == nextWord.charAt(i)) count++;
        }
        
        if (count == (len - 1)) return true;
        
        return false;
    }
}