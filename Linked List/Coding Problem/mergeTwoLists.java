class Node {
    int val;
    Node next;

    Node(int val) {
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


    private static Node zipperLists(Node head1, Node head2) {
        Node tail = head1;
        Node current1 = head1.next;
        Node current2 = head2;
        int count = 0;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.next = current2;
                current2 = current2.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
            }
            tail = tail.next;
            count += 1;
        }
        if (current1 != null) tail.next = current1;
        if (current2 != null) tail.next = current2;
        return head1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(5);

        Node head2 = new Node(7);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node mergeList = zipperLists(head1, head2);
        while (mergeList != null) {
            System.out.print(mergeList.val + " ");
            mergeList = mergeList.next;
        }
        System.out.println();
    }
}



// 2nd version

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


    private Node zipperLists(Node head1, Node head2) {
        Node tail = head1;
        Node current1 = head1.next;
        Node current2 = head2;
        int count = 0;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.next = current2;
                current2 = current2.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
            }
            tail = tail.next;
            count += 1;
        }
        if (current1 != null) tail.next = current1;
        if (current2 != null) tail.next = current2;
        return head1;
    }

    public static void main(String[] args) {
        LinkedList ob = new LinkedList();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node x = new Node("X");
        Node y = new Node("Y");
        Node z = new Node("Z");

        x.next = y;
        y.next = z;

        Node mergeList = ob.zipperLists(a, x);
        while (mergeList != null) {
            System.out.print(mergeList.val + " ");
            mergeList = mergeList.next;
        }
        System.out.println();
    }
}

