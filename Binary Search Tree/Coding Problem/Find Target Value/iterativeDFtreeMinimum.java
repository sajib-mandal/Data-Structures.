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

public class depthFirstIterative {

    Node root;

    depthFirstIterative(){
        this.root = null;
    }

    private int treeMinimum(Node root) {
        Stack<Node> stack = new Stack<>();
        int smallest = 1000;
        stack.add(root);
        while (stack.size() > 0) {
            Node current = stack.pop();
            if (current.val < smallest) smallest = current.val;

            if (current.left != null) stack.add(current.left);
            if (current.right != null) stack.add(current.right);
        }
        return smallest;
    }

    public static void main(String[] args) {
        depthFirstIterative ob = new depthFirstIterative();
        Node a = new Node(5);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(15);
        Node f = new Node(12);

        //       5
        //      /  \
        //     11   3
        //    /  \   \
        //   4    15  12

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println("Minimum value is: " + ob.treeMinimum(a));
    }
}
