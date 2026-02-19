class Solution {
    public int solution(int[][] sizes) {
        int result = 0;
        int n = sizes.length;
        
        int longerMax = Integer.MIN_VALUE;
        int shorterMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int longer = Math.max(sizes[i][0], sizes[i][1]);
            int shorter = Math.min(sizes[i][0], sizes[i][1]);
            
            if (longer > longerMax) {
                longerMax = Math.max(longer, longerMax);
            }
            
            if (shorter > shorterMax) {
                shorterMax = Math.max(shorter, shorterMax);
            }
        }
        
        result = longerMax * shorterMax;
        
        return result;
    }
}