import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9]; // 9난쟁이들의 키를 받는 배열
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(br.readLine()); // 9난쟁이 키받기
            sum += height[i]; // 9난쟁이 키의 합 구하기
        }
        Arrays.sort(height); // 키 오름차순 정렬

        int liar1 = 0;
        int liar2 = 0;
        // 9명 중 2명을 걸러내보자
        for (int i = 0; i < height.length; i++) {
            for(int j = i+1; j < height.length; j++) { // 2중 반복문으로 9명 중 2명을 고르는 모든 경우의 수 거쳐가기
                if (sum - (height[i] + height[j]) == 100) { // 2명빼고 나머지의 합이 100인 경우 그 제외해야되기 때문에 인덱스 기억해둠
                    liar1 = i;
                    liar2 = j;
                    break;
                }
            }
        }
        for (int i = 0; i < height.length; i++) { 
            if(i == liar1 || i == liar2) continue; // 저장해둔 두 명의 인덱스를 제외하고 출력(배열을 이미 오름차순 정렬해뒀으니 오름차순으로 출력된다)
            System.out.println(height[i]);
        }

    }
}