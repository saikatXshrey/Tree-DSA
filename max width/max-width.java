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

        System.out.println(maxWidth(root));
    }

    static int maxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            res = Math.max(res, size);

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return res;
    }
}