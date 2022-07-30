class Node{
    int key;
    Node left;
    Node right;

    Node(int data){
        key = data;
        left = null;
        right = null;
    }

}

public class BSTpost {
    // bst root node
    Node root;
    BSTpost(){
        root = null;
    }

    // InOrder Traversal - Left:rootNode:Right (LnR)
    void inOrder(Node node){
        if (node != null){
            // first traverse left subtree recursively
            inOrder(node.left);
            //then go for root node
            System.out.println(node.key + " ");
            // next traverse right subtree recursively
            inOrder(node.right);
        }
    }

    //PreOrder Traversal - rootNode:Left:Right (nLR)
    void preOrder(Node node){
        if (node != null){
            //first print root node first
            System.out.println(node.key + " ");
            // then traverse left subtree recursively
            preOrder(node.left);
            // next traverse right subtree recursively
            preOrder(node.right);
        }
    }

    void postOrder(Node node){
        if (node != null){
            // first traverse left subtree recursively
            postOrder(node.left);
            // then traverse right subtree recursively
            postOrder(node.right);
            //now process root node
            System.out.println(node.key + " ");
        }
    }

    // Wrappers for recursive functions
    void inOrderTraversal(){
        inOrder(root);
    }
    void preOrderTraversal(){
        preOrder(root);
    }
    void postOrderTraversal(){
        postOrder(root);
    }
}

class Main{
    public static void main(String[] args){
        //construct a BST
        BSTpost tree = new BSTpost();
        /*        45
                //  \\
                10   90
               // \\
               7   12      */
        tree.root = new Node(45);
        tree.root.left = new Node(10);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(12);
        //InOrder Traversal
        System.out.println("BST Inorder Traversal: ");
        tree.inOrderTraversal();
        //PreOrder Traversal
        System.out.println("\nBST Preorder Traversal: ");
        tree.preOrderTraversal();
        //PostOrder Traversal
        System.out.println("\nBST Postorder Traversal: ");
        tree.postOrderTraversal();
    }
}
