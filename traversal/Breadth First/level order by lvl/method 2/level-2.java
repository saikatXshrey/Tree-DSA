import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int k) {
        key = k;
        left = right = null;
    }
}

class Driver {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        lvl(root);
    }

    static void lvl(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node current = q.poll();
            if (current == null) {
                System.out.println();
                q.add(null);
            } else {
                System.out.print(current.key + " ");

                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
        }
    }
}