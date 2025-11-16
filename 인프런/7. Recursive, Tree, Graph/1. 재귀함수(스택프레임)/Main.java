import java.io.*;
import java.util.*;

class Main {
    static void recursive(int N) {
        if(N == 0) return;
        else {
            recursive(N-1);
            System.out.print(N + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        recursive(N);
    }
}