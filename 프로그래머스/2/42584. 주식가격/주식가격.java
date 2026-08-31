import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 미해결된 인덱스의 스택이 비어있지 않고, 스택의 맨 위의 인덱스에 해당하는 가격이 새로 갱신되는 가격보다 높을 때
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            } 
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            
            answer[index] = (prices.length - 1) - index;
        }
        
        return answer;
    }
}