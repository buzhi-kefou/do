package org.soulmate.offer;

public class I_26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null)
            return false;
        return find(A, B);
    }

    private boolean find(TreeNode a, TreeNode b) {
        if (a == null)
            return false;
        if (a.val == b.val) {
            return judge(a, b) || find(a.left, b) || find(a.right, b);
        } else {
            return find(a.left, b) || find(a.right, b);
        }
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if ((a == null) || (a.val != b.val))
            return false;
        return judge(a.left, b.left) && judge(a.right, b.right);
    }
}
