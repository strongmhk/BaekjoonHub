import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCount = 0;
        int baseCount = 0;
        
        Set<Integer> winNums = new HashSet<>();
        
        for (int num : win_nums) {
            winNums.add(num);
        }
        
        // 일치 확정, 미확정 개수 세기
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeroCount++;
            else if (winNums.contains(lottos[i])) baseCount++;
        }
        
        // 최고 순위와 최저 순위로 변환
        int maxCount = baseCount + zeroCount;
        int minCount = baseCount;
        
        answer[0] = calculateRanking(maxCount);
        answer[1] = calculateRanking(minCount);
        
        return answer;
    }
    
    static int calculateRanking(int count) {
        int result = 0;
        
        switch (count) {
            case 6:
                result = 1;
                break;
            case 5:
                result = 2;
                break;
            case 4:
                result = 3;
                break;
            case 3:
                result = 4;
                break;
            case 2:
                result = 5;
                break;
            default:
                result = 6;
        }
        
        return result;
    }
}

// 1. 일치 확정 개수 세기
// lottos를 순회하면서 win_nums에 포함돼있는지 확인하며 count
// 2. 0의 개수 세기
// 3. 최고 순위와 최저 순위 계산