class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 각 압축 단위 별로 압축된 문자열 길이 계산
        // 압축 단위가 문자열 길이의 반을 넘어가면 압축하는 의미가 없으므로 s.length() / 2까지만 반복
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            // 첫번째 덩어리 처리
            int count = 1;
            String prev = s.substring(0, unit);
            StringBuilder sb = new StringBuilder();
            
            // 두번째 덩어리부터 탐색
            for (int start = unit; start < s.length(); start += unit) {
                // 문자열이 압축 단위로 딱 떨어지지 않는 경우 마지막 덩어리 자를 때 오버플로우 방지
                int end = Math.min(start + unit, s.length());
                String current = s.substring(start, end);
                
                // 이전 문자열 덩어리와 같을 경우 count 증가
                if (prev.equals(current)) {
                    count++;
                // 이전 덩어리(prev)를 결과에 반영 (count > 1이면 숫자를 먼저 붙이고, 이후 문자열을 붙인다)
                } else {
                    // 현재 덩어리는 이전 덩어리의 연속을 끊었으므로 이전 덩어리를 이어붙여야함 
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    
                    // 다음 덩어리는 현재 덩어리와 다른 문자열이므로 다음 덩어리 탐색시 사용할 현재 덩어리를 prev에 저장
                    count = 1;
                    prev = current;
                }
            }
            
            // 아직 결과에 반영 안 된 마지막 덩어리 처리
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
