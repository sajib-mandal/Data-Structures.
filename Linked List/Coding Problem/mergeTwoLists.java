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


    private Node zipperLists(Node head1, Node head2) {
        Node dummyNode = new Node(0);
        Node tail = head1;
        tail = dummyNode;
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
        return tail;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        LinkedList ob = new LinkedList();
        LinkedList ob1 = new LinkedList();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;


        Node x = new Node(7);
        Node y = new Node(8);
        Node z = new Node(9);

        x.next = y;
        y.next = z;
        System.out.println(ob.zipperLists(a, x));
        //ob.printList();


    }
}
