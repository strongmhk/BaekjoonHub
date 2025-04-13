import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a+b<=c)
            c = a+b-1;
        else if (b+c<=a)
            a = b+c-1;
        else if (c+a<=b)
            b = c+a-1;

        System.out.println(a+b+c);
    }
}