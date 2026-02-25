class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for (int i = 3; i * i <= sum; i++) {
            if (sum % i == 0 && check(brown, yellow, sum / i, i)) {
                answer[0] = sum / i; // 더 큰 값(몫) -> 가로
                answer[1] = i; // 더 작은 값(나누는 수) -> 세로
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