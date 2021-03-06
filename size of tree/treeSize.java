
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

        System.out.println(getSize(root));
    }

    static int getSize(Node root) {
        if (root == null)
            return 0;
        else
            return (1 + getSize(root.left) + getSize(root.right));
    }
}