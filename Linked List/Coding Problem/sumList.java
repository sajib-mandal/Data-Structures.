class Node {
    int  val;
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

    // iterative version
    private int sumList(Node head) {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.val;
            current = current.next;
        }
        return sum;
    }
    // recursive
    private int recursiveSumList(Node head) {
        if (head == null) return 0;
        return head.val + recursiveSumList(head.next);
   }




    public static void main(String[] args) {
        LinkedList ob = new LinkedList();

        Node a = new Node(2);
        Node b = new Node(8);
        Node c = new Node(3);
        Node d = new Node(7);

        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Total sum is: " + ob.sumList(a));
        System.out.println("Total sum is: " + ob.recursiveSumList(a));
    }
}
