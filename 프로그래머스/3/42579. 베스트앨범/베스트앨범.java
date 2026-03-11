import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> num = new HashMap<>(); 
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int cnt = plays[i];
            
            num.put(g, num.getOrDefault(g, 0) + cnt);
            
            if (!music.containsKey(g)) {
                music.put(g, new HashMap<>());
            } 
            
            music.get(g).put(i, cnt);
        }
        
        List<String> keySet = new ArrayList(num.keySet());
        
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - num.get(s1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genreKey = new ArrayList(map.keySet());
            
            Collections.sort(genreKey, (s1, s2) -> {
                if (!map.get(s1).equals(map.get(s2))) {
                    return map.get(s2) - map.get(s1); // 재생 수 내림차순
                }
                return s1 - s2; // 고유번호 오름차순
            });
            
            answer.add(genreKey.get(0));
            if (genreKey.size() > 1) answer.add(genreKey.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}