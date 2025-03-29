import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        int firstNum = 0;
        int secondNum = 0;
        String result;
        
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
        
            firstNum = Integer.parseInt(st.nextToken());
            secondNum = Integer.parseInt(st.nextToken());
            
            if (firstNum == 0 & secondNum == 0) {
                break;
            } else if(secondNum % firstNum == 0) {
                result = "factor";
            } else if(firstNum % secondNum == 0) {
                result = "multiple";
            } else {
                result = "neither";
            }
            
            System.out.println(result);
        }    
    }
}