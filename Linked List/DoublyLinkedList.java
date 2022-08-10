class Node {
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public void insertFront(int item){
        Node node = new Node(item);

        if (isEmpty()){
            head = tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void insertBack(int item){
        Node node = new Node(item);

        if (isEmpty()){
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Add element at a specified place.
    public void insertAnywhere(int key, int item){
        Node node = new Node(item);

        Node curr = head;
        while (curr != null && curr.data != key){
            curr = curr.next;
        }

        if (curr == null){         // last element.
            System.out.println("Key not found.");
            return;
        }
        if (curr.next == null){
            curr.next = node;
            node.prev = curr;
            tail = node;
        } else {
            Node next = curr.next;
            curr.next = node;
            node.prev = curr;
            node.next = next;
            next.prev = node;

        }
    }
    // return head data.
    public int getFront(){
        if (isEmpty()){
            System.out.println("List is empty.");
            return -1;
        }

        return head.data;
    }

    // return tail data.
    public int getBack(){
        if (isEmpty()){
            System.out.println("List is empty.");
            return -1;
        }

        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        return curr.data;
    }

    //remove item at front.
    public int popFront(){
        if (isEmpty()){
            System.out.println("List is empty.");
            return -1;
        }
        int item = head.data;

        head = head.next;
        head.prev = null;
        return item;
    }

    // delete back.
    public int popBack(){
        if (isEmpty()){
            System.out.println("List is empty.");
            return -1;
        }

        Node curr = head;
        Node prev = null;


        while (curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        int item = curr.data;
        if (prev == null){
            head = null;
        } else {
            prev.next = null;
            curr.prev = null;
        }
        return item;
    }

    public int remove(int key){
        if (isEmpty()){
            System.out.println("List is empty.");
            return -1;
        }

        Node curr = head;
        while (curr != null && curr.data != key){
            curr = curr.next;
        }
        int item = curr.data;
        if (curr == null){
            System.out.println("Key not found.");
            return -1;
        }
        if (curr.prev == null){
            popFront();
        } else if (curr.next == null){
            popBack();
        } else {
            Node next = curr.next;
            Node prev = curr.prev;

            prev.next = next;
            next.prev = prev;

            curr.prev = null;
            curr.next = null;
            curr = null;
        }
        return item;
    }

    public boolean find(int key){
        if (isEmpty()){
            System.out.println("List is empty.");
            return false;
        }

        Node curr = head;
        while (curr != null && curr.data != key){
            curr = curr.next;
        }
        if (curr == null)
            return false;
        return true;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("List is empty.");
        } else {
            Node curr = head;
            while (curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public void printReverse(){
        if (isEmpty()){
            System.out.println("List is empty.");
        } else {
            Node curr = tail;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        DoublyLinkedList ob = new DoublyLinkedList();
        ob.insertFront(23);
        ob.insertFront(67);
        ob.insertBack(90);
        ob.insertFront(24);
        ob.insertBack(78);
        ob.insertAnywhere(67, 88);
        System.out.println("List is: ");
        ob.print();
        //ob.remove(67);
        System.out.println("Remove is: " + ob.remove(24));
        ob.print();
    }
}
