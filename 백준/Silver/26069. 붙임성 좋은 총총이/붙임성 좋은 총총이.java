import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        Set<String> dancingPeople = new HashSet<>(); //  춤추는 중인 사람들
        dancingPeople.add("ChongChong"); // 총총이는 춤추는 중!

        StringTokenizer st;

        String person1, person2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            person1 = st.nextToken();
            person2 = st.nextToken();

            if (dancingPeople.contains(person1) || dancingPeople.contains(person2)){
                dancingPeople.add(person1);
                dancingPeople.add(person2);
            }

        }

        System.out.println(dancingPeople.size());





    }
}