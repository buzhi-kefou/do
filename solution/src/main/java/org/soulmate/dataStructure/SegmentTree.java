package org.soulmate.dataStructure;

public class SegmentTree {

    static class Node {
        int l, r, val, lazy;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    Node[] tree = null;
    int[] data = null;

    private void init(int curr, int l, int r) {
        if (tree == null)
            tree = new Node[4 * (r + 1)];

        tree[curr] = new Node(l, r);

        if (l == r) {
            tree[curr].val = data[l];
        } else {
            int m = (r - l) / 2 + l;
            init(curr << 1, l, m);
            init(curr << 1 + 1, m + 1, r);
            tree[curr].val = tree[curr << 1].val + tree[curr << 1 + 1].val;
        }
    }

    private void pushDown(int curr) {
        int m = (tree[curr].r - tree[curr].l) / 2 + tree[curr].l;

        tree[curr << 1].lazy += tree[curr].lazy;
        tree[curr << 1 + 1].lazy += tree[curr].lazy;

        tree[curr << 1].val += tree[curr].lazy * (m - tree[curr].l + 1);
        tree[curr << 1 + 1].val += tree[curr].lazy * (tree[curr].r - m);

        tree[curr].lazy = 0;
    }

    private void pushUp(int index) {
        tree[index].val = tree[index << 1].val + tree[index << 1 + 1].val;
    }

    private void updateSingle(int curr, int index, int val) {
        if (tree[curr].l == index && tree[curr].r == index) {
            tree[curr].val += val;
            return;
        }

        int m = (tree[curr].r - tree[curr].l) / 2 + tree[curr].l;

        if (index <= m)
            updateSingle(curr << 1, index, val);
        else
            updateSingle(curr << 1 + 1, index, val);

        pushUp(curr);
    }

    private void updateRange(int curr, int l, int r, int val) {
        if (l <= tree[curr].l && r >= tree[curr].r) {
            tree[curr].val += (tree[curr].r - tree[curr].l + 1) + val;
            tree[curr].lazy = val;
            return;
        }

        if (tree[curr].lazy != 0)
            pushDown(curr);

        int m = (tree[curr].r - tree[curr].l) / 2 + tree[curr].l;
        if (l <= m)
            updateRange(curr << 1, l, r, val);
        if (r > m)
            updateRange(curr << 1 + 1, l, r, val);

        tree[curr].val = tree[curr << 1].val + tree[curr << 1 + 1].val;
    }

    private int query(int curr, int l, int r) {
        if (l <= tree[curr].l && r >= tree[curr].r)
            return tree[curr].val;

        if (tree[curr].lazy != 0)
            pushDown(curr);

        int m = (tree[curr].r - tree[curr].l) / 2 + tree[curr].l, ans = 0;
        if (l <= m)
            ans += query(curr << 1, l, r);
        if (r > m)
            ans += query(curr << 1 + 1, l, r);
        return ans;
    }

}
