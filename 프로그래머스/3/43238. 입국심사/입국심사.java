class Solution {
    public long solution(int n, int[] times) {
        long min = Long.MAX_VALUE;
        
        for (int time : times) {
            min = Math.min(min, time);
        }
        
        long left = 0L, right =  min * n;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            long count = 0;
            
            for (int time : times) {
                count += mid / time;
            }
            
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
            
        }
        
        return left;
    }
}