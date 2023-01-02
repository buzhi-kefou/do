package org.soulmate.offer;

public class I_55_II {

    public boolean isBalanced(TreeNode root) {
        func(root);
        return flag;
    }

    boolean flag = true;

    //dfs
    private int func(TreeNode node) {
        if (node == null || !flag)
            return 0;
        int left = func(node.left), right = func(node.right);

        if (Math.abs(left - right) > 1)
            flag = false;

        return Math.max(left, right) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
