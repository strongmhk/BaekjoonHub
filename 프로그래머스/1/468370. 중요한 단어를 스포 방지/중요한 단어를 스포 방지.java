import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> notImportants = getNotImportants(message, spoiler_ranges);
        Set<String> importants = new HashSet<>();
        
        for (int[] range : spoiler_ranges) {
            String word = getCompleteWord(range, message);
            
            // 하나의 구간에 여러 단어가 걸쳐있으면 각 단어 분리
            String[] splitWords = word.split("\\s+");
            
            for (String w : splitWords) {
                String tw = w.trim();
                if (!tw.isEmpty() && !notImportants.contains(tw)) {
                    importants.add(tw);
                }
            }
        }
        
        return importants.size();
    }
    
    // 스포 구간이 하나도 포함되지 않은 단어 추출
    public Set<String> getNotImportants(String origin, int[][] spoiler_ranges) {
        Set<String> notImportants = new HashSet<>();
        boolean[] isSpoiled = new boolean[origin.length()];
        
        // 스포일러 방지 구간 마킹
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (i >= 0 && i < origin.length()) {
                    isSpoiled[i] = true;
                }
            }
        }
        
        int i = 0;
        while (i < origin.length()) {
            if (origin.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            // 단어의 시작, 끝 인덱스 구하기
            int start = i;
            while (i < origin.length() && origin.charAt(i) != ' ') {
                i++;
            }
            
            int end = i - 1;
            
            // 스포일러 방지 구간 포함 여부
            boolean hasSpoiler = false;
            
            for (int j = start; j <= end; j++) {
                if (isSpoiled[j]) {
                    hasSpoiler = true;
                    break;
                }
            }
            
            // 스포일러 방지 구간 없으면 중요하지 않은 단어
            if (!hasSpoiler) {
                notImportants.add(origin.substring(start, end + 1));
            }
        }
        
        return notImportants;
    }
    
    // 스포 구간이 포함하는 단어들 추출
    public String getCompleteWord(int[] range, String origin) {
        int start = range[0];
        int end = range[1];
        int limit = origin.length();
        
        if (start < 0 || end >= limit || start > end) return "";
        
        while (start > 0 && origin.charAt(start - 1) != ' ') {
            start--;
        }
        
        while (end < limit - 1 && origin.charAt(end + 1) != ' ') {
            end++;
        }
        
        return origin.substring(start, end + 1).trim();
    }
}