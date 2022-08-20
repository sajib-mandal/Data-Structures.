/* Reverse linked List
and return new head
 */

class Node {
    String val;
    Node next;
    Node prev;

    Node(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList {
    Node head;
    Node tail;
    LinkedList() {
        this.head = null;
        this.tail = null;
    }
    // iterative version
    private String reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev.val;
    }

    // recursive version
    private String recursiveReverseList(Node head, Node prev) {
        if (head == null) return prev.val;
        Node next = head.next;
        head.next = prev;
        return recursiveReverseList(next, head);
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
        //System.out.println("New head is: " + ob.reverseList(a));
        System.out.println("New head is: " + ob.recursiveReverseList(a, null));

    }
}
