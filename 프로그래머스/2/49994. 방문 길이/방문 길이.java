import java.util.*;

class Solution {
    // U, D, L, R
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        Map<Character, Integer> commandMap = new HashMap<>();
        
        commandMap.put('U', 0);
        commandMap.put('D', 1);
        commandMap.put('L', 2);
        commandMap.put('R', 3);
        
        int curX = 0, curY = 0;
        
        for (char command : dirs.toCharArray()) {
            // 명령에 따라 다음 좌표 계산
            int idx = commandMap.get(command);
            int nx = curX + dx[idx];
            int ny = curY + dy[idx];
            
            // 좌표 범위 밖을 벗어나면 다음 반복으로 바로 넘어감
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 좌표 범위 안이면 해당 경로가 이미 방문 집합에 있는지 확인
            
            // 경로 값 구성(작은 좌표가 항상 먼저 오도록)
            boolean curIsSmaller = (curX < nx) || ((curX == nx) && (curY < ny));
            
            String key;
            
            if (curIsSmaller) {
                key = curX + "," + curY + "," + nx + "," + ny;
            } else {
                key = nx + "," + ny + "," + curX + "," + curY;
            }
            
            if (!visited.contains(key)) visited.add(key);
            
            // 다음 좌표로 이동
            curX = nx;
            curY = ny;
        }
        
        return visited.size();
    }
}

// 시작점과 끝점이 모두 방문했던 곳이면 이미 방문했던 길이고,
// 둘 중 하나라도 방문한 적이 없으면 방문하지 않음.