import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= 10; i++)
		{
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] heights = new int[N];
            
            for(int j = 0; j < N; j++) {
            	heights[j] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
            for(int k = 2; k < N - 2; k++) {
				int leftMax = Math.max(heights[k-1], heights[k-2]);             
            	int rightMax = Math.max(heights[k+1], heights[k+2]);
                int totalMax = Math.max(leftMax, rightMax);
                
                if(heights[k] > totalMax) {
                	sum += (heights[k] - totalMax);
                }
            }
            
            sb.append(String.format("#%d %d\n", i, sum));

		}
        
        System.out.println(sb);
	}
}