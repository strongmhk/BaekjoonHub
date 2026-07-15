import java.util.*;

class CustomDate {
    int year, month, day;
    
    public CustomDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> expiredPrivacies = new ArrayList<>();
        StringTokenizer st;
        
        // 유효기간 map 저장
        for (String t : terms) {
            st = new StringTokenizer(t, " ");
            String term = st.nextToken();
            int month = Integer.parseInt(st.nextToken());
            
            termsMap.put(term, month);
        }
        
        CustomDate todayDate = toCustomDate(today);
        
        // 개인정보별 파기여부 판단
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], " ");
            String strCollectDate = st.nextToken();
            String term = st.nextToken();
            
            // 유효한 기간과 현재 날짜를 표준화하여 비교
            CustomDate collectDate = toCustomDate(strCollectDate);
            int validMonth = termsMap.get(term);
            int validVal = normalize(collectDate.year, collectDate.month, collectDate.day) + (validMonth * 28 - 1);
            int todayVal = normalize(todayDate.year, todayDate.month, todayDate.day);
            
            if (todayVal > validVal) expiredPrivacies.add(i + 1);
        }
        
        int[] result = new int[expiredPrivacies.size()];
        
        for (int i = 0; i < expiredPrivacies.size(); i++) {
            result[i] = expiredPrivacies.get(i);
        }
        
        return result;
    }
    
    static CustomDate toCustomDate(String strDate) {
        StringTokenizer st = new StringTokenizer(strDate, ".");
        
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        return new CustomDate(year, month, day);
    }
    
    static int normalize(int year, int month, int day) {
        return (year * 12 * 28) + (month - 1) * 28 + (day - 1);
    }
}