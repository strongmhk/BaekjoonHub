import java.io.*;
import java.util.*;

class Main {
    static int L, C;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static char[] input;
    
    static void dfs(String pwd, int i) {
        if (pwd.length() == L) {
            int vowelCnt = 0;
            for (char c : pwd.toCharArray()) {
                for (char vw : vowels) {
                    if (c == vw) vowelCnt++;
                }
            }
            int consCnt = pwd.length() - vowelCnt;
            
            if (vowelCnt >= 1 && consCnt >= 2) System.out.println(pwd);
            return;
        } else {
            if (i == C) return;
        
            dfs(pwd + input[i], i + 1);
            dfs(pwd, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        input = new char[C];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) input[i] = st.nextToken().charAt(0);
        
        Arrays.sort(input);
        
        dfs("", 0);
    }
}