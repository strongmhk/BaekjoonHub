class Solution {
    public int solution(int n) {
        int quotient = n / 7;
        int remainder = (n % 7) == 0 ? 0 : 1;
        
        int result = quotient + remainder;
        return result;      
    }
}