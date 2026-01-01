import java.util.*;
import java.io.*;

class Grade implements Comparable<Grade> {
	public int p, i;
  	
  	public Grade(int p, int i) {
    	this.p = p;
      	this.i = i;
    }
  	
  	@Override
  	public int compareTo(Grade o) {
    	return this.p - o.p;
    }
}

class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  
  public static void solution(int N) throws Exception {
    ArrayList<Grade> arr = new ArrayList<>();
    int count = 0;
    int min = Integer.MAX_VALUE;
    
  	for (int i = 0; i < N; i++) {
    	st = new StringTokenizer(br.readLine(), " ");
      	int paper = Integer.parseInt(st.nextToken(), 10);
      	int interview = Integer.parseInt(st.nextToken(), 10);
      	arr.add(new Grade(paper, interview));
    }
    
    Collections.sort(arr);
    
    for (Grade g : arr) {
    	if (g.i < min) {
        	min = g.i;
          	count++;
        }
    }
    
    System.out.println(count);
  }
  
  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine(), 10);
    
    for (int i = 0; i < T; i++) {
    	int N = Integer.parseInt(br.readLine(), 10);
      	solution(N);
    }
  }
}