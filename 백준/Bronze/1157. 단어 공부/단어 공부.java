import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26]; // 알파벳 개수 = 배열의 size

        // 대문자로 출력하므로 입력받은값 대문자로 변환
        String a = sc.next().toUpperCase();

        int max = -1;
        char st = '?';

        for(int i = 0; i < a.length(); i++){
            arr[a.charAt(i)-65]++;
            if(max<arr[a.charAt(i)-65]){
                max = arr[a.charAt(i)-65];
                st = a.charAt(i);
            }
            else if(max == arr[a.charAt(i)-65]) st = '?';
        }
        System.out.println(st);
    }

}