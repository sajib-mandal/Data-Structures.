public class PriorityQueueHeap {
    private int heap[];
    private int size;
    private int maxSize;

    public PriorityQueueHeap(int maxsize){
        this.maxSize = maxsize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private static int parent(int i){
        return (i - 1)/ 2;
    }

    private static int leftChild(int i){
        return 2*i + 1;
    }

    private static int rightChild(int i){
        return 2*i + 2;
    }

    private void enQueue(int item){
        if (size >= maxSize){
            System.out.println("Heap Queue is full.");
            return;
        }
        //base case;
        heap[size] = item;
        size++;

        int i = size - 1;
        while (i != 0 && heap[PriorityQueueHeap.parent(i)] < heap[i]){
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = PriorityQueueHeap.parent(i);
        }
    }

    private void maxHeapify(int i){
        int largest = i;
        int l = PriorityQueueHeap.leftChild(i);
        int r = PriorityQueueHeap.rightChild(i);

        if (l <= size && heap[l] > heap[largest])
            largest = l;
        if (r <= size && heap[r] > heap[largest])
            largest = r;
        if(largest != i){
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largeat);
        }
    }

    private int deQueue(){
        int max = heap[0];
        heap[0] = heap[size -1];
        size--;
        maxHeapify(0);
        return max;
    }

    private int peek(){
        return heap[0];
    }

    private void printHeap(){
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        PriorityQueueHeap ob = new PriorityQueueHeap(12);
        ob.enQueue(16);
        ob.enQueue(14);
        ob.enQueue(10);
        ob.enQueue(8);
        ob.enQueue(7);
        ob.enQueue(9);
        ob.enQueue(3);
        ob.enQueue(2);
        ob.enQueue(4);
        ob.enQueue(1);
        System.out.println("Max heapify: ");
        ob.maxHeapify(0);
        ob.printHeap();
        System.out.println("Dequeue is: " + ob.deQueue());
        ob.maxHeapify(0);
        ob.printHeap();
    }
}
