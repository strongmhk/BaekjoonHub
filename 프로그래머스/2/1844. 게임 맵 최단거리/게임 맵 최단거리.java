import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dis = cur[2];
            
            if (x == n - 1 && y == m - 1) return dis;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny] == true) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dis + 1});  
            }
        }
        
        return -1;
    }
}