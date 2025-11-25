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

class Main {
    static int BFS(Node root) {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i < length; i++) {
                Node node = queue.poll();

                if (node.lt == null || node.rt == null) return level;
                if (node.lt != null) queue.offer(node.lt);
                if (node.rt != null) queue.offer(node.rt);
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(BFS(root));
    }
}