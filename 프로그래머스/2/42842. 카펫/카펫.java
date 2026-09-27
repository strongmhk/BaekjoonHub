class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 3; i * i <= sum; i++) {
            if (sum % i == 0 && check(brown, yellow, sum / i, i)) {
                answer[0] = sum / i;
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
    
    static boolean check(int brown, int yellow, int width, int height) {
        int targetBrownCnt = width * 2 + ((height - 2) * 2);
        int targetYellowCnt = (width - 2) * (height - 2);
        
        if (targetBrownCnt == brown && targetYellowCnt == yellow) return true;
        return false;
    }
}