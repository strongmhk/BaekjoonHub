import java.io.*;

class Stack{

    private int[] sArr;
    private int top;

    public Stack(int size){
        this.top = -1;
        this.sArr = new int[size];
    }

    public void push(int num){
        this.sArr[++top] = num;
    }

    public int pop(){
        if(top == -1) return -1;
        return this.sArr[top--];
    }

    public int size(){
        return this.top + 1;
    }

    public int empty(){
        if(top == -1) return 1; 
        return 0; 
    }

    public int top(){
        if(top == -1) return -1;
        return this.sArr[top];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      
        int n = Integer.parseInt(br.readLine());
        
        Stack stack = new Stack(n);

        
        for (int i = 0; i < n; i++) {
            
            String command = br.readLine();

            if (command.contains("push")) { 
                String[] spt = command.split(" "); 
                
                stack.push(Integer.parseInt(spt[1])); 
            } else if (command.contains("pop")) { 
                bw.write(String.valueOf(stack.pop()) + "\n");
            } else if (command.contains("size")) { 
                bw.write(String.valueOf(stack.size()) + "\n");
            } else if (command.contains("empty")) { 
                bw.write(String.valueOf(stack.empty()) + "\n");
            } else if (command.contains("top")) { 
                bw.write(String.valueOf(stack.top()) + "\n");
            }
        }


        bw.flush(); 
        bw.close(); 
        br.close();
    }
}
