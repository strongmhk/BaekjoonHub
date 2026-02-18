import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        
        int[] giftPoint = new int[n];
        int[][] giftGraph = new int[n][n];
        
        // (친구 : 배열 인덱스) map 생성
        Map<String, Integer> friendsMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            friendsMap.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            String giver = arr[0];
            String receiver = arr[1];
            
            // 선물 그래프 갱신
            int giverIdx = friendsMap.get(giver);
            int receiverIdx = friendsMap.get(receiver);
            giftGraph[giverIdx][receiverIdx]++;
            
            // 선물 지수 증/감 처리
            giftPoint[giverIdx]++;
            giftPoint[receiverIdx]--;
        }
        
        for (int i = 0; i < n; i++) {
            int giftCnt = 0;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                // 두 사람이 선물을 주고 받은 적이 있다면 -> a가 b한테 받은 선물보다 준 선물이 더 많을 때 b -> a한테 선물 줘야함
                if (giftGraph[i][j] != 0 || giftGraph[j][i] != 0) {
                    if (giftGraph[i][j] > giftGraph[j][i]) giftCnt++;
                } 
                // 두 사람이 선물을 주고 받은 적이 없거나, 같은 수로 주고 받았다면
                // 선물 지수가 더 큰 사람이 작은 사람에게 받음
                if (giftGraph[i][j] == 0 && giftGraph[j][i] == 0 || giftGraph[i][j] == giftGraph[j][i]) {
                    if (giftPoint[i] > giftPoint[j]) giftCnt++;
                }
            }
            
            answer = Math.max(answer, giftCnt);
        }
        
        return answer;
    }
}