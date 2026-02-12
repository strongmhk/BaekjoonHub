import java.io.*;
import java.util.*;

class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int airCleaner1Row, airCleaner2Row;
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
      	findAirCond();
      
        for (int i = 0; i < T; i++) {
            solve();
        }
      
      	int result = count();
      
      	System.out.println(result + 2); // -1 2개 더했으므로 2 더해주기
    }
    
  	static void findAirCond() {
    	for (int i = 0; i < R; i++) {             
          if (map[i][0] == -1) {
            airCleaner1Row = i;
            airCleaner2Row = i + 1;
            break;
          }
      }
    }
  
    static void solve() {
        map = dustSimulation(); 
        airSimulation();
    }
    
    // 미세먼지 확산
    static int[][] dustSimulation() {
        int[][] tMap = new int[50][50];
        
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] == -1) {
                    tMap[x][y] = -1;
                    continue;
                }
                
                tMap[x][y] += map[x][y];
                
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (map[nx][ny] == -1) continue;
                    
                    tMap[nx][ny] += (map[x][y] / 5);
                    tMap[x][y] -= (map[x][y] / 5);
                }
            }
        }
        
        return tMap;
    }
    
    // 공기청정기 작동
    static void airSimulation() {
        int top = airCleaner1Row; // 공기청정기 윗 부분 좌표, 반시계 방향으로 진행
        
      	// 좌측 영역
        for (int x = top - 1; x > 0; x--) {
        	map[x][0] = map[x - 1][0];
        }
        
      	// 위쪽 영역
      	for (int y = 0; y < C - 1; y++) {
        	map[0][y] = map[0][y + 1];
        }
        
      	// 오른쪽 영역
      	for (int x = 0; x < top; x++) {
        	map[x][C - 1] = map[x + 1][C - 1];
        }
      
      	// 아래쪽 영역
      	for (int y = C - 1; y > 1; y--) {
        	map[top][y] = map[top][y - 1];
        }
      
      	// 좌측 영역에서 공기청정기에 들어간 미세먼지가 정화돼서 나옴
      	map[top][1] = 0;
      
      	int bottom = airCleaner2Row; // 공기청정기 아래 부분 좌표, 시계 방향으로 진행
      	
      	// 좌측 영역
      	for (int x = bottom + 1; x < R - 1; x++) {
        	map[x][0] = map[x + 1][0];
        }
      
      	// 아래쪽 영역
      	for (int y = 0; y < C - 1; y++) {
        	map[R - 1][y] = map[R - 1][y + 1];
        }
      
      	// 우측 영역
      	for (int x = R - 1; x > bottom; x--) {
        	map[x][C - 1] = map[x - 1][C - 1];
        }
      
      	// 위쪽 영역
      	for (int y = C - 1; y > 1; y--) {
        	map[bottom][y] = map[bottom][y - 1];
        }
      
      	// 좌측 영역에서 공기청정기에 들어간 미세먼지가 정화돼서 나옴
      	map[bottom][1] = 0;
    }
  
  	static int count() {
      	int sum = 0;
    	for (int x = 0; x < R; x++) {
        	for (int y = 0; y < C; y++) {
            	sum += map[x][y];
            }
        }
      
      	return sum;
    }
}