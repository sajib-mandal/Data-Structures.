public class MyStack{
    private int[] stack;
    private int size;
    private int capacity;
    private int top;

    public MyStack(){
        capacity = 10;
        stack = new int[capacity];
        top = -1;
    }

    public int size(){
        return size = top + 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
/*
    public void push(int item) {
        // check for overflow
        if (top >= capacity - 1) {
            System.out.println("Error: Can not push item. Stack Overflow");
            return;
        }

        // insert the item and update the top
        stack[top + 1] = item;
        top = top + 1;
    }

 */


    public void push(int item){
        if (size == capacity){
            System.out.println("Stack overflow.");
            return;
        }
        stack[top + 1] = item;
        top = top + 1;
    }



    void printStack(){
        for (int i = 0; i < capacity; i++)
            System.out.print(stack[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        MyStack stack = new MyStack();

        stack.push(22);
        stack.push(44);
        stack.push(56);
        stack.push(88);
        stack.push(12);
        stack.push(21);
        stack.push(89);
        stack.push(40);
        stack.push(47);
        stack.push(48);
        stack.printStack();
        System.out.println("Stack size: " + stack.size());
    }
}
