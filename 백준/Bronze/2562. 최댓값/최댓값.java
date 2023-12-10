import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        int[] num_copy = new int[9];


        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            num_copy[i] = nums[i];
        }

        Arrays.sort(nums);

        int max = nums[8];
        int index = search_index(num_copy, max);

        System.out.println(max);
        System.out.println(index);

    }

    private static int search_index(int[] arr, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[i] == num) {
                return i+1;
            }
        }

        return -1;
    }

}