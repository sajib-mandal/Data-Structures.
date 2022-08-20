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
    // recursive
    private String getNode(Node head, int index) {
        if (head == null) return null;
        if (index == 0) return head.val;
        return getNode(head.next, index - 1);
    }

    // iterative

    private String iterativeGetNode(Node head, int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) return current.val;
            count += 1;
            current = current.next;
        }
        return null;
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

        System.out.println("Index value is: " + ob.getNode(a, 2));
        System.out.println("Index is: " + ob.iterativeGetNode(a, 3));


    }
}
