import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(numbers, N, M);
        System.out.println(result);


    }


    private static int search(int[] arr, int N, int M){
        int result = 0;

        // 3장 뽑을 것 이므로 첫번째 카드 N-2번까지 순회
        for (int i = 0; i < N-2; i++) {

            // 첫번째 카드가 M을 넘으면 선택 x
            if(arr[i] > M) continue;

            // 두번째 카드는 첫번째 카드 다음부터 N-1번 카드까지
            for (int j = i+1; j < N-1; j++) {

                // 첫번째 카드와 두번째 카드의 합이 M을 넘으면 선택 x
                if(arr[i] + arr[j] > M) continue;

                // 세번째 카드는 두번째 카드 다음부터 N번 카드까지 순회
                for (int k = j+1; k < N; k++) {

                    // 3개 카드 합 변수 temp
                    int temp = arr[i] + arr[j] + arr[k];

                    // 세 카드의 합이 M과 같으면 바로 리턴
                    if(temp == M) return temp;

                    // 세 카드의 합이 이전 합보다 크고 M보다 작으면 result 갱신
                    if(result < temp && temp < M) result = temp;

                }
            }
        }

        // 순회 모두 끝난 후 리턴
        return result;
    }
}
