class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] split = s.split(" ");
        
        int strCount = 0;
        for (String sp : split) {
            int charCount = 0;
            
            for (char c : sp.toCharArray()) {
                if (charCount == 0) c = Character.toUpperCase(c);
                else c = Character.toLowerCase(c);
                sb.append(c);
                charCount++;
            }
            
            strCount++;
            
            if (strCount < split.length) sb.append(" ");
        }
        
        return sb.toString();
    }
}