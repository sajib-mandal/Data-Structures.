public class HeapSort{
    void sort(int arr[]){
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        for (int i = n-1; i >=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    void maxHeapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i + 1;      // left child
        int r = 2*i + 2;      // right child

        if (l < n && arr[l] > arr[largest])    // avoid "<=" because it's give wrong answer
            largest = l;

        if (r < n && arr[r] > arr[largest])    // // avoid "<=" because it's give wrong answer
            largest = r;

        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, n, largest);
        }
    }
    void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is: ");
        ob.printArray(arr);

    }
}
