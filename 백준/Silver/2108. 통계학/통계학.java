import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stat = new int[4]; // 평균, 중위수, 최빈값, 범위
        int[] nums = new int[N];
        int sum = 0;
        int mode = 0;


        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        Arrays.sort(nums);

        int count[] = new int[8001]; // 각 값(-4000 ~ 4000)의 개수 세줄 배열
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            count[nums[i]+4000]++;
            max = Math.max(count[nums[i]+4000], max);
        }

        ArrayList<Integer> max_idx = new ArrayList<>();

        for(int i=0; i<=8000; i++) { // 최빈값이 여러 개 일 수도 있으므로 순회하면서 세준다
            if (max == count[i]) max_idx.add(i - 4000); // count[0]은 -4000의 개수, count[1]은 -3999의 개수, ... count[8000]은 4000의 개수이므로 인덱스
        }

        mode = max_idx.size() > 1 ? max_idx.get(1) : max_idx.get(0); // 최빈값 여러 개 일경우 두 번째로 작은 값 가져오기

        stat[0] = (int)Math.round((double) sum / N);  // 평균값
        stat[1] = nums[(N-1)/2]; //  중앙값
        stat[2] = mode; // 최빈값
        stat[3] = nums[N-1] - nums[0]; // 범위

        for (int i = 0; i <= 3; i++) System.out.println(stat[i]);


    }
}