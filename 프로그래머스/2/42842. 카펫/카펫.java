class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int height = 3; height * height <= total; height++) {
            if (total % height == 0) {
                int width = total / height;
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        
        return answer;
    }
}

// 1. 블럭 개수의 총합에 대한 약수를 구한다.(가로, 세로 너비 후보 구하기)
// 2. 각 조합에 대해 노란색 블럭 개수를 계산하고 yellow랑 맞는지 확인한다.
