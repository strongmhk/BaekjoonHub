import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        DFS(numbers, "", visited);
        
        return set.size();
    }
    
    static void DFS(String numbers, String current, boolean[] visited) {
        if (current.length() >= 1) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) set.add(num);
        } 
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}