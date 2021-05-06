package UnionFind;

public class WeightedQuickUnion {
    private int[] id;
    private int[] count;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            count[i] = 1;
        }
    }

    public int getRoot(int n) {
        while (n != id[n]) {
            id[n] = id[id[n]];
            n = id[n];
        }
        return n;
    }

    public boolean connected(int n, int m) {
        return getRoot(n) == getRoot(m);
    }

    public void addConnect(int m, int n) {
        int a = getRoot(m);
        int b = getRoot(n);
        if (a == b) return; //same union
        if (count[a] <= count[b]) {
            count[b] += count[a];
            id[a] = b;
        } else {
            count[a] += count[b];
            id[b] = a;
        }
    }

    public void prid() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        int root = qu.getRoot(4);
        boolean isUnion = qu.connected(3, 4);
        qu.addConnect(3, 4);
        qu.prid();
        qu.addConnect(4, 5);
        qu.prid();
        qu.addConnect(9, 5);
        boolean isUnionAfter = qu.connected(3, 5);
        System.out.println(root);
        System.out.println(isUnion);
        System.out.println(isUnionAfter);
        qu.prid();
    }
}
