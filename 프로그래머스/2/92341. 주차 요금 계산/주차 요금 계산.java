import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        StringTokenizer st;
        
        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();
            
            // 입차면 시각을 분 단위로 변경해서 map에 넣기
            if (type.equals("IN")) {
                inTime.put(carNum, timeToMinute(time));
            // 출차면 시간 계산해서 누적 이용 시간 map에 반영
            } else {
                int dist = timeToMinute(time) - inTime.get(carNum);
                inTime.remove(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + dist);
            }
        }
        
        // 출차 기록이 없는 차량들 처리
        for (Map.Entry<String, Integer> entrySet : inTime.entrySet()) {
            String carNum = entrySet.getKey();
            Integer enterMinute = entrySet.getValue();
            
            int dist = timeToMinute("23:59") - enterMinute;
            
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + dist);
        }
        
        // 요금 계산
        List<String> carNums = new ArrayList<>(totalTime.keySet());
        Collections.sort(carNums);
        
        int[] answer = new int[carNums.size()];
        
        for (int i = 0; i < answer.length; i++) {
            int useTime = totalTime.getOrDefault(carNums.get(i), 0);
            
            // 기본 시간이면 기본 요금
            if (useTime < fees[0]) {
                answer[i] = fees[1];
            } else {
                int extraMinute = useTime - fees[0];
                int extraTime = (extraMinute % fees[2] == 0) ? extraMinute / fees[2] : extraMinute / fees[2] + 1;
                int totalFee = fees[1] + extraTime * fees[3];
                
                answer[i] = totalFee;
            }
        }
        
        return answer;
    }
    
    static int timeToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        return hour * 60 + minute;
    }
}