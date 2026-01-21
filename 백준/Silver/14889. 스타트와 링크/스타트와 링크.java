import java.io.*;
import java.util.*;

class Main {
    static int[][] ability;
    static boolean[] isStartTeam;
    static int answer = Integer.MAX_VALUE;
    static int N;
    
    static int getDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;
    
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (isStartTeam[i] == true && isStartTeam[j] == true) startTeamScore += ability[i][j];
                if (isStartTeam[i] == false && isStartTeam[j] == false) linkTeamScore += ability[i][j];
            }
        }
        
        return Math.abs(startTeamScore - linkTeamScore);
    }
    
    static void dfs(int depth, int startNum) {
        if (depth == N/2) {
            answer = Math.min(answer, getDiff());
        } else {
            for (int i = startNum; i <= N; i++) {
                isStartTeam[i] = true;
                dfs(depth + 1, i + 1);
                isStartTeam[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        ability = new int[N + 1][N + 1];
        isStartTeam = new boolean[N + 1];
        
        StringTokenizer st;
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 1);
        
        System.out.println(answer);
    }
}