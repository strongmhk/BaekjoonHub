import java.util.*;

class Point {
    int x, y, dis;
    
    public Point(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int answer = 0;
        
        int m = maps.length;
        int n = maps[0].length;
        
        answer = BFS(maps, m, n);
        
        return answer;
    }
    
    static int BFS(int[][] maps, int m, int n) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(0, 0, 1));
        maps[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (maps[nx][ny] == 0) continue;
                if (nx == (m - 1) && ny == (n - 1)) return cur.dis + 1;
                
                queue.offer(new Point(nx, ny, cur.dis + 1));
                maps[nx][ny] = 0;
            }
        }
        
        return -1;
    }
}