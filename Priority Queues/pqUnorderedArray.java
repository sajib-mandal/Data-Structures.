public class PriorityQueueUA {
    int queue[];
    int size;
    int maxSize;

    public PriorityQueueUA(int maxsize){
        this.maxSize = maxsize;
        this.size = 0;
        queue = new int[maxSize];
    }

    private void enQueue(int item){
        if (size >= maxSize){
            System.out.println("Sad Queue is full.");
            return;
        }
        int i = size - 1;
        queue[i+1] = item;
        size++;
    }

    private int deQueue(){
        if (size == 0){
            System.out.println("Sad Queue is empty.");
            return -1;
        }
        int max = 0;
        for (int i = 1; i < size; i++){
            if (queue[max] < queue[i]){
                max = i;
            }
        }
        int item = queue[max];
        // replace the max with the last element
        queue[max] = queue[size -1];
        size--;
        return item;
    }

    private void printArray(){
        for (int i = 0; i < size; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        PriorityQueueUA ob = new PriorityQueueUA(10);
        ob.enQueue(5);
        ob.enQueue(1);
        ob.enQueue(7);
        ob.enQueue(3);
        ob.enQueue(9);
        ob.enQueue(0);

        System.out.println("Queue is: ");
        ob.printArray();

        System.out.println("Dequeue is: " + ob.deQueue());
        ob.printArray();
    }
}
