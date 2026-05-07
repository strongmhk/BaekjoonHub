import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 사람이름 : 행렬 인덱스 매핑
        HashMap<String, Integer> friendsMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            friendsMap.put(friends[i], i);
        }

        int n = friends.length;
        int[][] giftGraph = new int[n][n];
        int[] giftDegree = new int[n];

        // 인접 행렬, 선물 지수 계산
        for (String giftHist : gifts) {
            String[] split = giftHist.split(" ");
            String giver = split[0];
            String receiver = split[1];

            int giverIdx = friendsMap.get(giver);
            int receiverIdx = friendsMap.get(receiver);

            // 인접 행렬 계산
            giftGraph[giverIdx][receiverIdx]++;

            // 선물 지수 계산
            giftDegree[giverIdx]++;
            giftDegree[receiverIdx]--;
        }

        // 최댓값 계산
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int giftCnt = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                // 선물을 주고받은 기록이 있는 경우
                if (giftGraph[i][j] != 0 || giftGraph[j][i] != 0) {
                    // 더 많이 준 사람이 선물을 받음
                    if (giftGraph[i][j] > giftGraph[j][i]) giftCnt++;
                    // 선물을 주고받은 기록이 없거나 같은 수의 선물을 주고받았을 경우
                } else if ((giftGraph[i][j] == 0 && giftGraph[j][i] == 0) || giftGraph[i][j] == giftGraph[j][i]) {
                    // 선물 지수가 높은 사람이 선물을 받음
                    if (giftDegree[i] > giftDegree[j]) giftCnt++;
                }
            }

            answer = Math.max(answer, giftCnt);
        }

        return answer;
    }
}