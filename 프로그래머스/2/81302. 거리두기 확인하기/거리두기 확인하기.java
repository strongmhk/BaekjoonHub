class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            
            boolean flag = isOK(place);
            
            if (flag) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    boolean isOK(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    // 맨해튼 거리 2사이에 뭐가 없는지 체크
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        
                        int dist = Math.abs(i - nx) + Math.abs(j - ny);
                        
                        if (place[nx].charAt(ny) == 'P') {
                            return false;
                        } else if (place[nx].charAt(ny) == 'X') {
                            continue;
                        } else { // 붙어있는 자리가 빈자리일 경우 그 빈자리의 주변 탐색
                            for (int l = 0; l < 4; l++) {
                                int nx2 = nx + dx[l];
                                int ny2 = ny + dy[l];
                                
                                if (nx2 < 0 || nx2 >= 5 || ny2 < 0 || ny2 >= 5) continue;
                                if (nx2 == i && ny2 == j) continue;
                                
                                // 원래 자리의 주변 자리가 빈자리이면서, 그 빈자리의 주변에 사람이 있을 경우 거리두기 위반
                                if (place[nx2].charAt(ny2) == 'P') return false;
                            }
                        }
                    }
                    
                }
            }
        }
        
        // 위반하고 있는게 없으면 true
        return true;
    }
}