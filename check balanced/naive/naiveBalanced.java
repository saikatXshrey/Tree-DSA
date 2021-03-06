
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
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);

        System.out.println(isBalanced(root));
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

    static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int lt = height(root.left);
        int rt = height(root.right);

        return (Math.abs(lt - rt) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }
}