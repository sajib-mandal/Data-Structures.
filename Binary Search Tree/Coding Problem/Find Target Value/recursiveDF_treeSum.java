class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class depthFirstRecursive {
    Node root;

    depthFirstRecursive(){
        this.root = null;
    }

    private int treeSum(Node root) {
        if (root == null) return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static void main(String[] args) {
        depthFirstRecursive ob = new depthFirstRecursive();
        Node a = new Node(3);
        Node b = new Node(11);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(1);

        //       3
        //      /  \
        //     11   4
        //    /  \   \
        //   4    2   1

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println("Tree Sum is: " + ob.treeSum(a));
    }
}
