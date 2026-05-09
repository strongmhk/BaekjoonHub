import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return BFS(maps, maps.length, maps[0].length);
    }

    static int BFS(int[][] maps, int n, int m) {
        // 큐에 {x좌표, y좌표, 이동거리} 형태의 배열을 넣기
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dy = {0, 1, 0, -1};
        int result = -1;

        // 시작 좌표 큐에 넣고 방문 처리
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dis = cur[2];

            if (x == n - 1 && y == m - 1) return dis;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny] == true) continue;

                queue.offer(new int[]{nx, ny, dis + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}