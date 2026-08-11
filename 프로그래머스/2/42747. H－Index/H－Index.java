import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int total = citations.length;
        for (int i = 0; i < citations.length; i++) {
            int num = citations[i]; // 인용 횟수
            int count = total - i; // 인용횟수가 num 이상인 논문의 개수
            
            if (num >= count) return count;
        }
        
        return 0;
    }
}