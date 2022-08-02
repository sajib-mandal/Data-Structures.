class Node{
    int data;
    Node prev;
    Node next;

    public Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}

class MyQueueLinkedList{
    Node head = null;
    Node tail = null;

    boolean isEmpty(){
        return head == null && tail == null;
    }

    //Add operation
    public void push(int item){
        Node node = new Node(item);
        if (isEmpty()){
            tail = head =  node;
            //return;
        } else{
            tail.next = node;
            tail = node;
        }
    }

    // Delete operation
    public int pop(){
        if (isEmpty()){
            System.out.println("Empty.");
            return -1;
        }
        int item = head.data;
        head = head.next;
        //head.prev = null;
        return item;
    }

    // peak element first
    public int peek(){
        if (isEmpty()){
            System.out.println("Linked List is Empty.");
            return -1;
        }
        return head.data;
    }
}

public class QueueLinkedList {
    public static void main(String[] args){
        MyQueueLinkedList ob = new MyQueueLinkedList();
        // Add elements on linked list;
        ob.push(6);
        ob.push(7);
        ob.push(8);
        // peek & pop operation on linked_list
        System.out.println("Peek is: " + ob.peek());
        System.out.println(ob.pop());
        System.out.println("Peek is: " + ob.peek());
        System.out.println(ob.pop());
        System.out.println("Peek is: " + ob.peek());
        System.out.println(ob.pop());
    }
}
