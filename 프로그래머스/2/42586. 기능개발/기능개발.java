import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int restDays = remain / speeds[i];
            
            if (remain % speeds[i] != 0) restDays++;
            
            queue.offer(restDays);
        }
        
        int count = 1;
        int base = queue.poll();
        
        while (!queue.isEmpty()) {
            int next = queue.peek();
            // 다음 기능 작업 배포일이 앞의 작업 배포일보다 늦으면 먼저 배포
            if (base < next) {
                result.add(count);
                count = 1;
                base = queue.poll();
            // 다음 기능 작업이 이미 완료된 상태이면 함께 배포
            } else {
                queue.poll();
                count++;
            }
        }
        
        // 마지막 count 담기
        result.add(count);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
