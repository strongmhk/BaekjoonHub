import java.util.*;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;
    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // 맨처음 루트 노드 큐에 넣기
        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            System.out.print(level + " : ");

            for(int i = 0; i < length; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if(current.lt != null) queue.offer(current.lt);
                if(current.rt != null) queue.offer(current.rt);
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }
}