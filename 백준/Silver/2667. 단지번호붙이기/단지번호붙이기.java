import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static ArrayList<Integer> result;
    static int N;

    static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && visited[nx][ny] == false) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for (int x = 0; x < N; x++) {
            String line = br.readLine();
            for (int y = 0; y < N; y++) {
                map[x][y] = line.charAt(y) - '0';
            }
        }

        result = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    count = 0;
                    dfs(x, y);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int c : result) {
            System.out.println(c);
        }
    }
}
