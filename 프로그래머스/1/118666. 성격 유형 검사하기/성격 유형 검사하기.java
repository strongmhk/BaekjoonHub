import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] indicate = {
            {'R', 'T'},
            {'C', 'F'},
            {'J', 'M'},
            {'A', 'N'},
        };
        
        Map<Character, Integer> point = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];
            
            char negative = s.charAt(0);
            char positive = s.charAt(1);
            
            switch (choice) {
                case 1:
                    point.put(negative, point.getOrDefault(negative, 0) + 3);
                    break;
                case 2:
                    point.put(negative, point.getOrDefault(negative, 0) + 2);
                    break;
                case 3:
                    point.put(negative, point.getOrDefault(negative, 0) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    point.put(positive, point.getOrDefault(positive, 0) + 1);
                    break;
                case 6:
                    point.put(positive, point.getOrDefault(positive, 0) + 2);
                    break;
                case 7:
                    point.put(positive, point.getOrDefault(positive, 0) + 3);
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 각 지표별 성격 유형 판단
        for (char[] i : indicate) {
            char t1 = i[0];
            char t2 = i[1];
            
            int p1 = point.getOrDefault(t1, 0);
            int p2 = point.getOrDefault(t2,0 );
            
            if (p1 > p2) {
                sb.append(t1);
            } else if (p1 < p2) {
                sb.append(t2);
            } else {
                char c = ((int) t1 > (int) t2) ? t2 : t1;
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}