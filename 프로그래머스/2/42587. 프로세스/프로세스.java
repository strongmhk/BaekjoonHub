import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        while (!queue.isEmpty()) {
            // 1. 큐에서 현재 빼야할 거 확인
            boolean hasHigherPriority = false;
            int[] current = queue.peek();
            
            // 2. 큐에 남은 것 중에서 우선 순위가 더 높은거 있는지 확인
            for (int[] element : queue) {
                if (element[1] > current[1]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            // 3. 처리
            if (hasHigherPriority) {
                queue.offer(queue.poll());
            } else {
                int[] removed = queue.poll();
                count++;
                
                if (removed[0] == location) {
                    return count;
                }
            }
            
        }
        
        return count;
    }
}