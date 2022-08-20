class Node {
    String val;
    Node next;

    Node(String val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    Node tail;
    LinkedList() {
        this.head = null;
        this.tail = null;
    }
    // iterative solution
    private boolean findTarget(Node head, String target) {

        Node current = head;
        while(current != null) {
            if (current.val == target) return true;
            current = current.next;
        }
        return false;
    }

    // recursive solution
    private boolean recursiveFindTarget(Node head, String target) {
        //it's represent end of my linkedList or empty likedList.
        if (head == null) return false;
        if (head.val == target) return true;
        return recursiveFindTarget(head.next, target);
    }


    public static void main(String[] args) {
        LinkedList ob = new LinkedList();

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println("Target is: " + ob.findTarget(a, "E"));
        System.out.println("Target is: " + ob.recursiveFindTarget(a, "F"));

    }
}
