import java.util.*;

class Solution {
    public int[] solution (int n) {
        int[][] arr = new int[n][n];
        List<Integer> result = new ArrayList<>();
        
        int num = 1, row = -1, col = 0;
        
        for (int i = 0; i < n; i++) {            
            if (i % 3 == 0) {
                // 아래쪽 이동
                for (int j = 0; j < n - i; j++) {
                    arr[++row][col] = num++;
                }
                
            } else if (i % 3 == 1) {
                // 오른쪽 이동
                for (int j = 0; j < n - i; j++) {
                    arr[row][++col] = num++;
                }
            } else {
                // 좌측 상단으로 이동
                for (int j = 0; j < n - i; j++) {
                    arr[--row][--col] = num++;
                }
            }
        }
        
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(arr[i][j]);
            }
        }
        
        return result.stream()
                     .mapToInt(value -> value.intValue())
                     .toArray();
    }
}