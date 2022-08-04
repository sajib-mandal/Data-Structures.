public class MaxHeap {
    private final int heap[];
    private int size;
    private final int maxsize;

    MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[maxsize];
    }

    private static int parent(int i){
        return (i - 1) / 2;
    }

     private static int leftChild(int i){
        return 2*i + 1;
    }

    private static int rightChild(int i){
        return 2*i + 2;
    }

    private void insert(int data){
        if (size >= maxsize){
            System.out.println("Sad heap is full.");
            return;
        }
        heap[size] = data;
        size++; 

        int i = size - 1;
        while (i != 0 && heap[MaxHeap.parent(i)] < heap[i]){
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MaxHeap.parent(i);
        }
    }

    private void maxHeapify(int i){
        int l = MaxHeap.leftChild(i);      // left child
        int r = MaxHeap.rightChild(i);     // right child
        int largest = i;

        if (l <= size && heap[l] > heap[largest])
            largest = l;
        if (r <= size && heap[r] > heap[largest])
            largest = r;

        if (largest != i){
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    private int getMax(){
        return heap[0];
    }

    private int extractMax(){
        int maxElem = heap[0];

        heap[0] = heap[size -1];   // replace the first item with the last item
        size--;

        maxHeapify(0);
        return maxElem;
    }

    private void print(){
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        MaxHeap ob = new MaxHeap(15);
        //insert elements;
        ob.insert(16);
        ob.insert(14);
        ob.insert(10);
        ob.insert(8);
        ob.insert(7);
        ob.insert(9);
        ob.insert(3);
        ob.insert(2);
        ob.insert(4);
        ob.insert(1);
        ob.insert(18);
        //Heap operation
        ob.maxHeapify(0);
        System.out.println("Max heapify.");
        ob.print();
        System.out.println("Max element is: " + ob.getMax());
        System.out.println("Extract Max: " + ob.extractMax());
        ob.maxHeapify(0);
        System.out.println("New array is: ");
        ob.print();
    }
}
