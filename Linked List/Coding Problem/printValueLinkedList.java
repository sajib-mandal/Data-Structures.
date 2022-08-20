class Node {
    String val;
    Node next;

    Node(String val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {
    private void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // Recursive solution

    private void recursivePrintLinkedList(Node head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        recursivePrintLinkedList(head.next);
    }


    public static void main(String[] args) {
        LinkedList ob = new LinkedList();

        //Creating a Node and next point to null.
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        //Creating linkedList.
        // A -> B -> C -> D -> NULL
        a.next = b;
        b.next = c;
        c.next = d;

        ob.printLinkedList(a);
        System.out.println("\nRecursive linked List.");
        ob.recursivePrintLinkedList(a);
    }
}
