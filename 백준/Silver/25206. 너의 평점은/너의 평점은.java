import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;  // 이수한 과목의 총 학점
        double gpaSum   = 0.0;  // 전공평점의 합

        for (int i = 0; i < 20; i++) { // 20줄에 걸쳐 주어짐
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken(); // 과목명, 저장 안해도 됨
            double credit = Double.parseDouble(st.nextToken()); // 학점, 3.0, 4.0 ...
            String grade = st.nextToken(); // 등급, A+, A0, ...

            if (!grade.equals("P")) {  // 등급이 P면 계산에서 제외
                n += credit; // 총 학점 계산
                switch (grade) {  // 등급에 따라 과목평점을 계산
                    case "A+":
                        gpaSum += 4.5 * credit;
                        break;
                    case "A0":
                        gpaSum += 4.0 * credit;
                        break;
                    case "B+":
                        gpaSum += 3.5 * credit;
                        break;
                    case "B0":
                        gpaSum += 3.0 * credit;
                        break;
                    case "C+":
                        gpaSum += 2.5 * credit;
                        break;
                    case "C0":
                        gpaSum += 2.0 * credit;
                        break;
                    case "D+":
                        gpaSum += 1.5 * credit;
                        break;
                    case "D0":
                        gpaSum += credit;
                        break;
                    case "F":
                        gpaSum += 0.0;
                        break;
                }
            }
        }
        double average = gpaSum / n;  // 전공평점 계산
        System.out.println(average);
    }
}