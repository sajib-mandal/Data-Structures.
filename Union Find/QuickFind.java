public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    private void validate(int p){
        int n = id.length;
        if (p < 0 || p >= n){
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n -1));
        }
    }

    public int find(int p){
        validate(p);
        return id[p];
    }

    public boolean connected(int p, int q){
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void union(int p, int q){
        validate(p);
        validate(q);
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args){
        QuickFind ob = new QuickFind(10);
        ob.union(4, 3);
        ob.union(3, 8);
        ob.union(6, 5);
        ob.union(9, 4);
        ob.union(2, 1);
        ob.union(5, 0);
        ob.union(7, 2);
        ob.union(6, 1);

        System.out.println("Find is: " + ob.find(9));
        System.out.println("Count is: " + ob.count());
        System.out.println("Connected is: " + ob.connected(1, 5));
    }

}
