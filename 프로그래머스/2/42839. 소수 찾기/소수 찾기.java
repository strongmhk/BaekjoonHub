import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        visited = new boolean[n];
        
        DFS(numbers, "");
        
        return set.size();
    }
    
    static void DFS(String numbers, String current) {
        if (current.length() > 0) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) set.add(num);
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(numbers, current + numbers.charAt(i));
                visited[i] = false; // 백트래킹
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