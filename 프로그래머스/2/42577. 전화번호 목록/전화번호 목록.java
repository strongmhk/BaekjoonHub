import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            StringBuilder substr = new StringBuilder();
            // 주의 : 자기 자신까지 탐색하면 무조건 contains가 true가 되므로 자기 자신은 배제
            for (int i = 0; i < phone.length() - 1; i++) {
                substr.append(phone.charAt(i));
                if (set.contains(substr.toString())) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}