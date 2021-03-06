
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

        System.out.println(treeDiameter(root));
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else
            return (Math.max(height(root.left), height(root.right)) + 1);
    }

    static int treeDiameter(Node root) {
        if (root == null)
            return 0;

        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = treeDiameter(root.left);
        int d3 = treeDiameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }
}