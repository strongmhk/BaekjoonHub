import java.util.*;

class FileInfo {
    String originalName;
    String head;
    int number;
    
    public FileInfo(String originalName, String head, int number) {
        this.originalName = originalName;
        this.head = head;
        this.number = number;
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileInfo> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String original = files[i];
            int end = 0;
            
            // 파일명 쪼개서 파일명 객체로 생성 후 리스트에 넣기
            for (int j = 0; j < original.length(); j++) {
                if (Character.isDigit(original.charAt(j))) {
                    end = j;
                    
                    while (end < original.length() && Character.isDigit(original.charAt(end)) && end - j < 5) {
                        end++;
                    }
                    
                    String head = original.substring(0, j);
                    int number = Integer.parseInt(original.substring(j, end));
                    
                    FileInfo file = new FileInfo(original, head, number);
                    fileList.add(file);
                    
                    break;
                }
            }
            
        }
        
        fileList.sort((a, b) -> {
            int headCompare = a.head.compareToIgnoreCase(b.head);
            
            if (headCompare != 0) return headCompare;
            
            return Integer.compare(a.number, b.number);
        });
        
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).originalName;
        }
            
        return answer;
    }
}