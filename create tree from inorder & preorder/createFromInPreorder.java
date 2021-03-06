
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
        int[] in = { 20, 10, 40, 30, 50 };
        int[] pre = { 10, 20, 30, 40, 50 };

        Node root = createTree(pre, in, 0, in.length - 1);

        inorder(root);
    }

    static int preIndex = 0;

    static Node createTree(int[] pre, int[] in, int start, int end) {
        if (start > end)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (start == end)
            return root;

        int inIndex = findInorderIndex(root.key, in);

        root.left = createTree(pre, in, start, inIndex - 1);
        root.right = createTree(pre, in, inIndex + 1, end);

        return root;
    }

    static int findInorderIndex(int val, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val)
                return i;
        }
        return -1;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}