
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
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(9);

        System.out.println(sumProp(root));
    }

    static boolean sumProp(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum = sum + root.left.key;
        if (root.right != null)
            sum = sum + root.right.key;

        return (sum == root.key && sumProp(root.left) && sumProp(root.right));
    }
}