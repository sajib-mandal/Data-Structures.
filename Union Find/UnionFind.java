public class UnionFind{
    private int[] parent;
    private byte[] rank;
    private int count;

    public UnionFind(int n){
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p){
        validate(p);
        while (p != parent[p]){
            return find(parent[p]);   // recursive call find;
        }
        return p;
    }

    public int count(){
        return count;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (rank[rootP] < rank[rootQ]){
            parent[rootP] = rootQ;
        }
        else if (rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
        }
        else{
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    private void validate(int p){
        int n = parent.length;
        if (p < 0 || p >= n){
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n -1));
        }
    }

    public static void main(String[] args){
        UnionFind ob = new UnionFind(10);
        /*
        ob.union(4, 3);
        ob.union(3, 8);
        ob.union(6, 5);
        ob.union(9, 4);
        ob.union(2, 1);
        ob.union(5, 0);
        ob.union(7, 2);
        ob.union(6, 1);

         */

        ob.union(0,0);
        ob.union(4, 1);
        ob.union(4,5);

        ob.union(2, 3);
        ob.union(2, 6);
        ob.union(6, 3);
        ob.union(3, 7);

        System.out.println("Find is: " + ob.find(6));
        //System.out.println("Count is: " + ob.count());
        System.out.println("Connected is: " + ob.connected(1, 5));
    }
}
