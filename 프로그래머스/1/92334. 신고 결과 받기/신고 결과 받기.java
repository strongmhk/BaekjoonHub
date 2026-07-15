import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        
        // 신고자 -> 신고한 사용자 목록
        Map<String, Set<String>> reportHist = new HashMap<>();
        // 피신고자 -> 신고 당한 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
        
        for (String r : report) {
            String[] arr = r.split(" ");
            String reporter = arr[0];
            String reported = arr[1];
            
            // 신고자의 신고 목록에 추가
            if (!reportHist.containsKey(reporter)) {
                reportHist.put(reporter, new HashSet<>());
            }
            boolean firstReport = reportHist.get(reporter).add(reported);
            
            // 중복 신고가 아닌 경우에만 신고당한 횟수 증가
            if (firstReport) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            }
        }
        
        // 각 사용자가 받을 결과 메일 수 계산
        for (int i = 0; i < id_list.length; i++) {
            Set<String> reportedUsers = reportHist.getOrDefault(id_list[i], Collections.emptySet());
            // 해당 사용자가 신고한 사람들을 확인
            for (String reported : reportedUsers) {
                int count = reportedCount.getOrDefault(reported, 0);
                if (count >= k) result[i]++;
            }
        }
        
        return result;
    }
}