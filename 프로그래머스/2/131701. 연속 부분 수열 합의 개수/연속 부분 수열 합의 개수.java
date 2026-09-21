import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int N = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for (int start = 0; start < N; start++) {
            int sum = 0;
            
            for (int len = 1; len <= N; len++) {
                int index = (start + len - 1) % N;
                sum += elements[index];
                set.add(sum);
            }
        }
        
        return set.size();
    }

}