public class PriorityQueueOA {
    int queue[];
    int maxSize;
    int size;

    PriorityQueueOA(int maxsize){
        this.maxSize = maxsize;
        this.size = 0;
        queue = new int[maxSize];
    }

    private void enqueue(int item){
        if (size >= maxSize){                   // why not "maxSize - 1"??  Because size start 0. "this.size = 0".
            System.out.println("Sad Queue is full.");
            return;
        }

        int i = size - 1;
        while (i >=0 && item < queue[i]){
            queue[i + 1] = queue[i];    // not queue[i] = queue[i + 1]. Because it's give wrong answer;
            i--;
        }
        queue[i + 1] = item;
        size++;
    }

    private int dequeue(){
        if (size == 0){
            System.out.println("Queue is empty.");
            return -1;
        }
        int item;
        item = queue[size - 1];
        size--;
        return item;
    }

    private void print(){
        for (int i = 0; i < size; i++)
            System.out.print(queue[i] + " ");
        System.out.println();

    }
    public static void main(String[] args){
        PriorityQueueOA ob = new PriorityQueueOA(12);
        ob.enqueue(1);
        ob.enqueue(2);
        ob.enqueue(3);
        ob.enqueue(5);
        ob.enqueue(9);
        ob.enqueue(8);
        System.out.println("Array is: ");
        ob.print();
        System.out.println("Dequeue is: " + ob.dequeue());
        ob.print();
    }
}
