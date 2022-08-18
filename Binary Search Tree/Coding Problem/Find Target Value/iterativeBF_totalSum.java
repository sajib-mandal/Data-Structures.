import java.util.*;
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

public class breathFirstIterative {

    Node root;

    breathFirstIterative(){
        this.root = null;
    }

    private int treeSum(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        int totalSum = 0;
        if (root == null) return 0;
        queue.add(root);

        while (queue.size() > 0) {
            Node current = queue.poll();
            totalSum += current.val;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return totalSum;
    }




    public static void main(String[] args) {
        breathFirstIterative ob = new breathFirstIterative();
        Node a = new Node(9);
        Node b = new Node(11);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(1);

        //       9
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
