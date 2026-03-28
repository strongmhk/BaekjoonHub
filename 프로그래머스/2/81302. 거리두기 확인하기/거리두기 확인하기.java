import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < 5; i++) {
            String[] p = places[i];
            
            boolean isOk = true;
            for (int r = 0; r < 5 && isOk == true; r++) {
                for (int c = 0; c < 5 && isOk == true; c++) {
                    // 모든 자리 탐색할 필요 X, 사람있는 곳에서만 탐색 시작
                    if (p[r].charAt(c) == 'P') {
                        if (BFS(r, c, p) == false) isOk = false;
                    }
                }
            }
            
            answer[i] = (isOk == true) ? 1 : 0;
        }
        
        return answer;
    }
    
    static boolean BFS(int r, int c, String[] p) {
        
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
            
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || (nr == r && nc == c)) continue;
                if (visited[nr][nc] == true) continue;
                
                int d = Math.abs(nr - r) + Math.abs(nc - c);
                if (d > 2) continue;
                
                visited[nr][nc] = true;
                
                if (p[nr].charAt(nc) == 'P' && d <= 2) return false;
                else if (p[nr].charAt(nc) == 'O' && d < 2) queue.offer(new int[] {nr, nc});
            }
        }
        return true;
    }
}