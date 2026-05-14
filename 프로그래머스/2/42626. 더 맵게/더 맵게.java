import java.util.*;

class Solution {
    public int solution(int[] scovile, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scovile) {
            pq.offer(s);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            
            int result = firstMin + secondMin * 2;
            
            pq.offer(result);
            count++;
        }
        
        if (pq.size() <= 1 && pq.peek() < K) return -1;
        
        return count;
    }
}