
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

        Node head = toDLL(root);
        displaylist(head);
    }

    static Node prev = null;

    static Node toDLL(Node root) {
        if (root == null)
            return root;

        Node head = toDLL(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        toDLL(root.right);
        return head;
    }

    static void displaylist(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.right;
        }
    }
}