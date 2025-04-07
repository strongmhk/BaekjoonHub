import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[] xCoord = new int[3];
        int[] yCoord = new int[3];
                
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            xCoord[i] = Integer.parseInt(st.nextToken());
            yCoord[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(getCoord(xCoord) + " " + getCoord(yCoord));    
    }
    
    static int getCoord(int[] coord) {
        if(coord[0] == coord[1]) {
            return coord[2];
        } else if(coord[1] == coord[2]) {
            return coord[0];
        } else {
            return coord[1];
        }
    }
}