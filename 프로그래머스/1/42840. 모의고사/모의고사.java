import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        return calc(answers);
    }
    
    static int[] calc(int[] answers) {
        int n = answers.length;
        int[] counts = new int[3];
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (answers[i] == pattern1(i)) counts[0]++;
            if (answers[i] == pattern2(i)) counts[1]++;
            if (answers[i] == pattern3(i)) counts[2]++;
        }
        
        for (int count : counts) {
            if (count > max) max = Math.max(max, count);
        }
        
        for (int i = 0; i < 3; i++) {
            if (counts[i] == max) result.add(i + 1);
        }
        
        int[] res = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    static int pattern1(int num) {
        int[] arr = {1, 2, 3, 4, 5};
        return arr[num % 5];
    }
    
    static int pattern2(int num) {
        int[] arr = {2, 1, 2, 3, 2, 4, 2, 5};
        
        return arr[num % 8];
    }
    
    static int pattern3(int num) {
        int[] arr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        return arr[num % 10];
    }
}