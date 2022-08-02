public class QueueArray{
    private int arr[];
    private int size;
    private int front;
    private int rear;

    public QueueArray(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public void enQueue(int data){
        if (rear == size - 1){
            System.out.println("Queue is full.");
            return;
        }
        rear = rear + 1;
        arr[rear] = data;
    }

    public int deQueue(){
        if (isEmpty()){
            System.out.println("Empty Queue.");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++){
            arr[i] = arr[i + 1];
        }
        rear = rear - 1;  // rear--
        return front;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Empty queue.");
            return -1;
        }
        return arr[0];
    }

    public void printArray(){
        for (int i = -1; i < rear; i++)
            System.out.print(arr[i + 1] + " ");
        System.out.println();
    }



    public static void main(String[] args){
        QueueArray q = new QueueArray(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(1);
        q.enQueue(2);
        q.printArray();
        System.out.println("DeQueue is: " + q.deQueue());
        q.printArray();
        System.out.println("Peek is: " + q.peek());
    }
}
