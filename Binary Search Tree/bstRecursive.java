public class BinarySearchTree {
    class Node{
        int key;
        Node parent;
        Node left;
        Node right;

        Node(int data){
            key = data;
            parent = left = right = null;
        }
    }
    Node root;

    BinarySearchTree(){
        root = null;
    }

    Node minimum(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    Node maximum(Node root){
        while (root.right != null){
            root = root.right;
        }
        return root;
    }
    Node successor(Node x){
        if (x.right != null){
            return minimum(x.right);
        }
        Node y = x.parent;
        while (y != null && y.right == x){
            x = y;
            y = y.parent;
        }
        return y;

    }

    Node predecessor(Node x){
        if (x.left != null){
            return maximum(x.left);
        }
        Node y = x.parent;
        while (y != null && y.left == x){
            x = y;
            y = y.parent;
        }
        return y;
    }
    Node insert_recursive(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert_recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_recursive(root.right, key);
        return root;
    }

    void insert(int key){
        root = insert_recursive(root, key);
    }

    Node searchRecursive(Node root, int key){
        if (root == null || root.key == key)
            return root;
        if (key < root.key)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    boolean search(int key){
        root = searchRecursive(root, key);
        if (root != null)
            return true;
        else
            return false;
    }


    Node searchTree(int key){
        return searchRecursive(root, key);
    }

 
    Node deleteRecursive(Node root, int key){
        if (root == null) return root;
        else if(key < root.key)
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key)
            root.right = deleteRecursive(root.right, key);
        else{
            if (root.left == null && root.right == null){
                root = null;
            }
            else if (root.left == null){
                Node temp = root;
                root = root.right;
            }
            else if(root.right == null){
                Node temp = root;
                root = root.left;
            }

            else{
                Node temp = minimum(root.right);
                root.key = temp.key;
                root.right = deleteRecursive(root.right, temp.key);
            }
        }
        return root;
    }
    void deleteKey(int key){
        root = deleteRecursive(root, key);
    }

    void inorderRecursive(Node root){
        if (root != null){
            inorderRecursive(root.left);
            System.out.println(root.key + " ");
            inorderRecursive(root.right);
        }
    }
    void inorder(){
        inorderRecursive(root);
    }

    void preorderRecursive(Node root){
        if (root != null){
            System.out.println(root.key + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
    void preorder(){
        preorderRecursive(root);
    }

    void postorderRecursive(Node root){
        if (root != null){
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.println(root.key + " ");
        }
    }
    void postorder(){
        postorderRecursive(root);
    }
}

class Main{
    public static void main(String[] args){
        BinarySearchTree ob = new BinarySearchTree();
        ob.insert(45);
        ob.insert(10);
        ob.insert(7);
        ob.insert(12);
        ob.insert(90);
        ob.insert(50);
        
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   
        
        */

        System.out.println("Inorder:");
        ob.inorder();
        System.out.println("Preorder");
        ob.preorder();
        System.out.println("Postorder");
        ob.postorder();
        System.out.println("delete 12: ");
        ob.deleteKey(12);
        ob.inorder();
        System.out.println("delete 90: ");
        ob.deleteKey(90);
        ob.inorder();
        System.out.println("delete 45: ");
        ob.deleteKey(45);
        ob.inorder();

        boolean result = ob.search(50);
        System.out.println("Element is present: " +result);
        System.out.println("Element is present: " + ob.search(5));
    }
}
