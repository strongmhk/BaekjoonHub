class Solution {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 현재 위치 (* = 10, # = 12 로 표현)
        int left = 10;
        int right = 12;

        for (int num : numbers) {

            // 0은 11로 치환 (좌표 계산 편하게)
            if (num == 0) num = 11;

            // 왼쪽 라인
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = num;
            }
            // 오른쪽 라인
            else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = num;
            }
            // 가운데 라인
            else {
                int leftDist = getDistance(left, num);
                int rightDist = getDistance(right, num);

                if (leftDist < rightDist) {
                    answer.append("L");
                    left = num;
                } else if (rightDist < leftDist) {
                    answer.append("R");
                    right = num;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = num;
                    } else {
                        answer.append("L");
                        left = num;
                    }
                }
            }
        }

        return answer.toString();
    }

    // 맨해튼 거리 계산
    private int getDistance(int from, int to) {
        int fromX = (from - 1) / 3;
        int fromY = (from - 1) % 3;

        int toX = (to - 1) / 3;
        int toY = (to - 1) % 3;

        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}