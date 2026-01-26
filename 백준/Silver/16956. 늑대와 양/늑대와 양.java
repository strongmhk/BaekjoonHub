import java.io.*;
import java.util.*;

class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static char[][] map;
    static int R, C;
    static boolean flag = true;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'D';
                    }
                    
                    if (map[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        
        for (int x = 0; x < R; x++) {
            String line = br.readLine();
            for (int y = 0; y < C; y++) {
                map[x][y] = line.charAt(y);
                if (map[x][y] == 'W') queue.add(new int[] {x, y});
            }
        }
        
        bfs();
        
        StringBuilder sb = new StringBuilder();
        
        if (flag == true) {
            sb.append("1").append("\n");
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    sb.append(map[x][y]);
                }
                sb.append("\n");
            }
        } else {
            sb.append("0");
        }
        
        System.out.println(sb);
    }
}
