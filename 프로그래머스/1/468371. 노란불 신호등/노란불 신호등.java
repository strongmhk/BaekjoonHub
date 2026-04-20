class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        int lcmTime = 1;
        
        // 최소공배수 구하기
        for (int i = 0; i < n; i++) {
            int cycle = signals[i][0] + signals[i][1] + signals[i][2];
            lcmTime = lcm(lcmTime, cycle);
        }
        
        // 각 시간별 신호등 신호 확인
        for (int t = 1; t <= lcmTime; t++) {
            boolean isAllYellow = true;
            
            // 각 신호등 신호 확인
            for (int i = 0; i < n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int C = g + y + r;
                
                int remain = (t - 1) % C;
                
                if (!(g <= remain && remain < g + y)) {
                    isAllYellow = false;
                    break;
                }
                
            }
            
            // 모두 노란색 신호면 해당 시점 반환
            if (isAllYellow) {
                return t;
            }
        }
        
        return -1;
    }
    
    // 최소공배수 구하기
    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    
    // 최대공약수 구하기
    public int gcd(int a, int b) {
        while(b > 0){
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}