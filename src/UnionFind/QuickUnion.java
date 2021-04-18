package UnionFind;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int getRoot(int n) {
        while (n != id[n]) {
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
        id[a] = b;
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
