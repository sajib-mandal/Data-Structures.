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

public class MaxPathSumRootToLeaf {

    Node root;

    MaxPathSumRootToLeaf(){
        this.root = null;
    }

    private int maxRootSum(Node root) {
        if (root.left == null || root.right == null) return root.val;
        int maxChild = Math.max(maxRootSum(root.left), maxRootSum(root.right));
        return root.val + maxChild;
    }

    public static void main(String[] args) {
        MaxPathSumRootToLeaf ob = new MaxPathSumRootToLeaf();
        Node a = new Node(5);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(1);

        //       5              "    5       "      5     "       5         "  
        //      /  \                /              /               \
        //     11   3    MRL       11 is "20"     11  is "18"       3 is "9"
        //    /  \   \            /                 \                \
        //   4    2   1         " 4          "       2    "           1      "

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println("Maximum root-sum-path is: " + ob.maxRootSum(a));
    }
}
