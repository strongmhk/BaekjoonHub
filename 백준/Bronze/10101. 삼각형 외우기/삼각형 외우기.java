import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
                
        System.out.println(solution(a, b, c));
    }
    
    static String solution(int a, int b, int c) {
        int sum = a + b + c;
        
        if(sum != 180) return "Error";
        else {
            if(a == b && b == c) return "Equilateral";
            else if(a == b || b == c || a == c) return "Isosceles";
            else return "Scalene";
        }
    }
}