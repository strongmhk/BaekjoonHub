import java.io.*;
import java.util.*;

class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static char[][][] map;
    static boolean[][][] visited;
    static int[][][] dis;
    static int L, R, C;
    
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    
    static StringBuilder sb = new StringBuilder();
    
    static void bfs(int sz, int sx, int sy) {
        queue = new LinkedList<>();
        queue.add(new int[]{sz, sx, sy});
        visited[sz][sx][sy] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cz = cur[0], cx = cur[1], cy = cur[2];
            
            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nz < 0 || nz >= L) continue;
                if (nx < 0 || nx >= R) continue;
                if (ny < 0 || ny >= C) continue;
                if (map[nz][nx][ny] == '#' || visited[nz][nx][ny] == true) continue;
                
                visited[nz][nx][ny] = true;
                dis[nz][nx][ny] = dis[cz][cx][cy] + 1;
                
                if (map[nz][nx][ny] == 'E') {
                    sb.append("Escaped in ")
                      .append(dis[nz][nx][ny])
                      .append(" minute(s).\n");
                    return;
                }
                
                queue.add(new int[]{nz, nx, ny});
            }
        }
        
        sb.append("Trapped!\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if (L == 0 && R == 0 && C ==0) break;
            
            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            dis = new int[L][R][C];
            
            int[] start = new int[3];
            
            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    String line = br.readLine();
                    for (int y = 0; y < C; y++) {
                        map[z][x][y] = line.charAt(y);
                        if(map[z][x][y] == 'S') {
                            start[0] = z;
                            start[1] = x;
                            start[2] = y;
                        }
                    }
                    
                }
                br.readLine(); // 층 사이 빈줄 제거
            }
            
            bfs(start[0], start[1], start[2]);
        }
        
        System.out.println(sb);
    }
}