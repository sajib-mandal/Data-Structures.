public class QueueArray {
    private int capacity;
    private int[] queue;
    private int front;
    private int rear;

    public QueueArray(){
        capacity = 10;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enQueue(int item){
        if (rear >= capacity - 1){
            System.out.println("Queue is full.");
            return;
        }
        queue[rear + 1] = item;
        rear = rear + 1;
    }
    public void printQueue(){
        for(int i = 0; i < capacity; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }
    public static void main(String[] args){
        QueueArray ob = new QueueArray();
        ob.enQueue(4);
        ob.enQueue(6);
        ob.enQueue(4);
        ob.enQueue(6);
        ob.enQueue(4);
        ob.enQueue(6);
        ob.enQueue(4);
        ob.enQueue(6);
        ob.enQueue(4);
        ob.enQueue(6);
        ob.enQueue(4);
        ob.enQueue(6);
        ob.printQueue();
    }
}
