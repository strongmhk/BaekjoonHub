import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];

    static void dfs(int row, int col) {
        // 해당 행이 다 채워졌을 경우 다음 행의 첫번째 열으로 이동
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0); // 출력 뒤 시스템 종료
        }

        // 해당 위치의 값이 0이라면 1~9 중에서 가능한 값 탐색
        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0; // 백트래킹
            return;
        }

        dfs(row, col + 1);
    }

    static boolean possibility(int row, int col, int value) {

        // 같은 행에서 중복 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return false;
        }

        // 같은 열에서 중복 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // 3 x 3 박스 영역 안에서 중복 검사
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int x = 0; x < 9; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < 9; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }
}
