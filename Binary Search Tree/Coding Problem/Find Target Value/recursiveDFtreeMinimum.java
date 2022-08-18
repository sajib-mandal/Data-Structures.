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

    private int treeMinimum(Node root) {
        if (root == null) return 100;
        int leftVal = treeMinimum(root.left);
        int rightVal = treeMinimum(root.right);
        return Math.min(root.val, Math.min(leftVal, rightVal));
        //return Math.min(Math.min(root.val, leftVal), rightVal);
    }

    /* Most efficient way to find smallest of 3 numbers Java?
       * double smallest = Math.min(a, Math.min(b, c));
       * return Math.min(Math.min(a, b), c);
     */

    public static void main(String[] args) {
        depthFirstRecursive ob = new depthFirstRecursive();
        Node a = new Node(5);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(15);
        Node f = new Node(12);

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

        System.out.println("Tree minimum value is: " + ob.treeMinimum(a));
    }
}
