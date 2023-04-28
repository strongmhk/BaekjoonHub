import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Queue{
    private int[] qArr;
    private int front;
    private int rear;
    public Queue(int size){
        this.front = -1;
        this.rear = -1;
        this.qArr = new int[size];
    }

    public void push(int num){
        this.qArr[++rear] = num;
        if(this.front == -1) this.front = 0;

    }

    public int pop(){
        if(this.front == -1 || this.front > this.rear) return -1;
        return qArr[this.front++];
    }


    public int size(){
        if(this.front == -1 || this.front > this.rear) return 0;
        return (this.rear - this.front + 1);
    }

    public int empty(){
        if(this.front == -1 || this.front > this.rear) return 1;
        return 0;
    }

    public int front(){
        if(this.front == -1 || this.front > this.rear) return -1;
        return qArr[front];
    }

    public int back(){
        if(this.front == -1 || this.front > this.rear) return -1;
        return qArr[rear];
    }


}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue queue = new Queue(n);

        for(int i = 0; i < n; i++){
            String command = br.readLine();
            if(command.contains("push")){
                String[] spt = command.split(" ");
                queue.push(Integer.parseInt(spt[1]));
            }
            else if(command.contains("pop")) {
                bw.write(String.valueOf(queue.pop() + "\n"));
            }
            else if(command.contains("size")) {
                bw.write(String.valueOf(queue.size() + "\n"));
            }
            else if(command.contains("empty")) {
                bw.write(String.valueOf(queue.empty() + "\n"));
            }
            else if(command.contains("front")) {
                bw.write(String.valueOf(queue.front() + "\n"));
            }
            else if(command.contains("back")) {
                bw.write(String.valueOf(queue.back() + "\n"));
            }

        }
        bw.flush();
        bw.close();
        br.close();


    }

}