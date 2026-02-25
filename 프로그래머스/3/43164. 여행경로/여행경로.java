import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] useTicket;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        useTicket = new boolean[n];
        
        DFS("ICN", "ICN", 0, n, tickets);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    static void DFS(String now, String path, int depth, int n, String[][] tickets) {
        if (depth == n) {
            list.add(path);
            return;
        }
    
        for (int i = 0; i < n; i++) {
            String start = tickets[i][0];
            String destination = tickets[i][1];
        
            if (!useTicket[i] && now.equals(start)) {
                useTicket[i] = true;
                DFS(destination, path + " " + destination, depth + 1, n, tickets);
                useTicket[i] = false;
            }
        }
    }
}