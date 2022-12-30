package org.soulmate.offer;

public class I_68_II {

    static TreeNode x, y;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        x = p;
        y = q;
        return recursive(root);
    }

    private TreeNode recursive(TreeNode node) {
        if (node == null)
            return null;

        TreeNode tempL = recursive(node.left), tempR = recursive(node.right);
        if (tempL != null && tempR != null)
            return node;

        if (node.val == x.val || node.val == y.val) {
            return node;
        }

        if (tempL != null)
            return tempL;
        if (tempR != null)
            return tempR;
        return null;
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
