class Node{
    int data;
    Node prev;
    Node next;

    Node(int item){
        data = item;
        prev = next = null;
    }
}

public class MyStackLinkedList {
    private Node tail;

    MyStackLinkedList(){
        tail = null;   // top of the stack also called pointer;
    }

    public void push(int item){
        Node node = new Node(item);
        if (tail == null){
            tail = node;
        } else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public int pop(){
        if (tail == null){
            System.out.println("Stack is empty.");
            return -566;  // Any - number. Because return int.
        }
        int item = tail.data;
        Node prev = tail.prev;
        if(prev != null){
            prev.next = null;
        }
        tail.prev = null;
        tail = prev;
        return item;
    }

    public int peek(){
        if (tail == null){
            System.out.println("Stack is empty.");
            return -877;
        }
        return tail.data;
    }
    

    public static void main(String[] args){
        MyStackLinkedList ob = new MyStackLinkedList();
        ob.push(67);
        ob.push(88);
        System.out.println(ob.pop());
        System.out.println(ob.peek());
    }

}
