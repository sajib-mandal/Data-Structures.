/* iterative breath-first-values
in Binary search tree using Queue. */

import java.util.*;
class Node {
    String val;
    Node left;
    Node right;
    Node(String val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class breathFirstSearch {
    Node root;
    breathFirstSearch(){
        this.root = null;
    }

    private void breathFirstTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            Node current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        breathFirstSearch ob = new breathFirstSearch();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //           a
        //         /  \
        //        b    c
        //       / \    \
        //      d   e    f
        // [a, b, d, e, c, f]

        ob.breathFirstTraversal(a);

    }
}
