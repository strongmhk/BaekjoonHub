import java.util.*;

class Distance {
    public int index;
    public int dis;
    
    public Distance(int index, int dis) {
        this.index = index;
        this.dis = dis;
    }
}

class Solution {
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        
        visited = new boolean[n];
        
        answer = BFS(words, begin, target);
        
        return answer;
    }
    
    static int BFS(String[] words, String begin, String target) {
        Queue<Distance> queue = new LinkedList<>();
        
        int[] nextWordIdx = getNextWordIdx(words, begin);
        
        for (int idx : nextWordIdx) {
            if (words[idx].equals(target)) return 1;
            queue.offer(new Distance(idx, 1));
            visited[idx] = true;
        }
        
        while(!queue.isEmpty()) {
            Distance cur = queue.poll();
            
            nextWordIdx = getNextWordIdx(words, words[cur.index]);
            
            for (int idx : nextWordIdx) {
                if (visited[idx] == true) continue;
                if (words[idx].equals(target)) return cur.dis + 1;
                
                queue.offer(new Distance(idx, cur.dis + 1));
                visited[idx] = true;
            }
        }
        
        return 0;
    }
    
    // words에서 변환 가능한 단어의 인덱스를 리턴
    static int[] getNextWordIdx(String[] words, String targetWord) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            // 1글자만 차이나면 포함
            int count = 0;
            String word = words[i];
            
            char[] c1 = word.toCharArray();
            char[] c2 = targetWord.toCharArray();
            
            for (int j = 0; j < c1.length; j++) {
                if (c1[j] == c2[j]) count++;
            }
            
            if (count == (word.length() - 1)) list.add(i);
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;  
    }
}


