import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력 값을 받는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과를 출력하는 BufferedWriter
        
        int N = Integer.parseInt(br.readLine());	//입력받을 문자열 개수
        int result=0;					            //그룹 단어 개수
        
        for(int i = 0; i < N;i++) {       		
            String text = br.readLine();
            result+=groupWordChecker(text);
        }
        
        bw.write(result + "\n");			//결과 bw에 저장
        bw.flush();					            //결과 출력
        bw.close();
        br.close();
    }
    
    public static int groupWordChecker(String text) {		//그룹 단어 체커 함수
        int[] arr = new int[26];				//알파벳 사용 횟수 배열
        boolean check= false;					//문자열이 그룹 단어인지 확인형 변수
        char temp = text.charAt(0);				//첫 번째 글자 받기
        
        for(int j = 1;j < text.length();j++) {
            
            if(temp != text.charAt(j)) {			//그룹 단어인지 체크 확인
                
                if(arr[text.charAt(j)-97] !=0) {
                    check = true;
                    break;
                }else {
                    arr[temp-97]++;
                    temp = text.charAt(j);
                }
                
            }
            
        }
        
        if(check)						//그룹 단어이면 1 아니면 0을 리턴
            return 0;
        else
            return 1;
    }
    
}