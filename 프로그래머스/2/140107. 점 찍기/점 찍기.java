class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int x = 0; x <= d; x += k) {
            // x가 고정된 상태에서 가능한 y좌표의 개수 구하기
            
            // 현재 가능한 y의 최댓값 구하기
            long dSquared = (long) d * d;
            long xSquared = (long) x * x;
            
            long maxY = (long) Math.sqrt(dSquared - xSquared);
            
            // 최대 y값에 따라 가능한 y값 구하기
            
            long count = (long) (maxY / k + 1);
            
            answer += count;
        }
        
        return answer;
    }
}
