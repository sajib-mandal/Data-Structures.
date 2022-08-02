class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList{
    private Node head;
    private Node tail;
    public MyLinkedList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public void insertAtFront(int value){
        Node node = new Node(value);

        if (isEmpty()){
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertAtBack(int value){
        Node node = new Node(value);
        if (isEmpty()){
            head = tail = node;
        } else {
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
            tail = node;
        }
    }

    public void insertAfter(int key, int value){
        Node node = new Node(value);

        Node curr = head;
        while(curr != null && curr.data != key){
            curr = curr.next;
        }
        if (curr == null){
            System.out.println("Key not found.");
            return;
        }
        if(curr.next == null){
            curr.next = node;
        } else{
            Node next = curr.next;
            curr.next = node;
            node.next = next;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Nothing to display.");
        } else {
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

}




public class SinglyLinkedList {
    public static void main(String[] args){
        MyLinkedList ob = new MyLinkedList();
        ob.insertAtBack(5);
        ob.insertAtFront(8);
        ob.insertAtFront(9);
        ob.insertAtBack(10);
        ob.insertAtBack(99);
        ob.insertAfter(5, 88);
        ob.print();

    }
}
