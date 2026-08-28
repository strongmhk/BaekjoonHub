class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        
        
        // rows x columns 크기의 행렬 구성
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        for (int j = 0; j < queries.length; j++) {
            int x1 = queries[j][0] - 1, y1 = queries[j][1] - 1, x2 = queries[j][2] - 1, y2 = queries[j][3] - 1;
            
            // 이동 진행
            int current = matrix[x1][y1]; // 다음 원소 값이 덮어씌워지지 않도록 보존
            int min = current;

            // 위쪽 : 왼쪽 -> 오른쪽
            for (int y = y1 + 1; y <= y2 ; y++) {
                int next = matrix[x1][y];
                matrix[x1][y] = current;
                
                current = next;
                min = Math.min(current, min);
            }
            
            // 오른쪽 : 위 -> 아래
            for (int x = x1 + 1; x <= x2; x++) {
                int next = matrix[x][y2];
                matrix[x][y2] = current;
                
                current = next;
                min = Math.min(current, min);
            }

            // 아래쪽 : 오른쪽 -> 왼쪽
            for (int y = y2 - 1; y >= y1; y--) {
                int next = matrix[x2][y];
                matrix[x2][y] = current;
                
                current = next;
                min = Math.min(current, min);
            }
            
            // 왼쪽 : 아래 -> 위
            for (int x = x2 - 1; x >= x1; x--) {
                int next = matrix[x][y1];
                matrix[x][y1] = current;

                current = next;
                min = Math.min(current, min);
            }
            
            // 이동 완료 후 최솟값
            answer[j] = min;
        }
        
        return answer;
    }
}