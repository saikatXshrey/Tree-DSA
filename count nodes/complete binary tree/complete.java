
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

        int nodes = countCompleteBTree(root);
        System.out.println(nodes);
    }

    static int countCompleteBTree(Node root) {
        int lh = 0;
        int rh = 0;

        Node current = root;

        while (current != null) {
            lh = lh + 1;
            current = current.left;
        }

        current = root;

        while (current != null) {
            rh = rh + 1;
            current = current.right;
        }

        if (lh == rh)
            return (int) Math.pow(2, lh) - 1;
        else
            return 1 + countCompleteBTree(root.left) + countCompleteBTree(root.right);
    }
}