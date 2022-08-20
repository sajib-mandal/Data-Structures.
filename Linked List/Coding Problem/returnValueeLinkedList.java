/* Return an array values */

import java.util.*;

class Node {
    String  val;
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

    // iterative version
    private ArrayList<String> linkedListValues(Node head) {
        ArrayList<String> array = new ArrayList<>();
        Node current = head;
        while (current != null) {
            array.add(current.val);
            current = current.next;
        }
        return array;
    }



    //Recursive values  "Error occer fixd it

    private ArrayList<String> recursiveLinkedListValue(Node head) {
        ArrayList<String> array = new ArrayList<>();
        //Node current = head;
        if (head == null) return array;
        array.add(head.val);
        recursiveLinkedListValue(head.next);
        return array;
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

        System.out.println("Array value is: " + ob.linkedListValues(a));
        System.out.println("New array is: " + ob.recursiveLinkedListValue(a));


    }
}
