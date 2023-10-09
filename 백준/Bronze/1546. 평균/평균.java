import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double[] scores = new double[N];
        double max = 0;
        double sum = 0;
        double inputScore = 0;
        StringBuilder sb = new StringBuilder();
        

        for (int i = 0; i < N; i++) {
            inputScore = Integer.parseInt(st.nextToken());
            if(inputScore > max){
                max = inputScore;
            }
            scores[i] = inputScore;
        }


        for (int i = 0; i < N; i++) {
            double outputScore = scores[i] / max * 100;
            scores[i] = outputScore;
            sum += (double) (scores[i]);
        }

        sb.append(sum / N);
        System.out.println(sb);




    }
}