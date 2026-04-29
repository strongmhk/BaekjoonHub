import java.util.*;

class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String collectDate = split[0];
            String type = split[1];
            
            int period = termMap.get(type);
            
            int collectDays = toDays(collectDate);
            int validDays = collectDays + period * 28;
            int todayDays = toDays(today);
            
            if (todayDays >= validDays) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    static int toDays(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }
}