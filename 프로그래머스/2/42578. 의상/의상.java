import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for (int count : map.values()) {
            result *= (count + 1);
        }
        
        return result - 1;
    }
}