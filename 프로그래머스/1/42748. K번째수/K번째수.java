import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        for (int[] command : commands) {
            int i = command[0], j = command[1], k = command[2];
            answer[idx] = getKnum(array, i, j, k);
            
            idx++;
        }
     
        return answer;
    }
    
    static int getKnum(int[] arr, int i, int j, int k) {
        
        int size = j - i + 1;
        
        int[] subArr = new int[size];
        
        int n = 0;
        
        for (int idx = i - 1; idx < j; idx++) {
            subArr[n] = arr[idx];
            n++;
        }
        
        Arrays.sort(subArr);
        
        return subArr[k - 1];        
    }
}