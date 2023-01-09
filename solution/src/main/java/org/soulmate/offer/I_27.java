package org.soulmate.offer;

public class I_27 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        change(root);
        return root;
    }

    private void change(TreeNode node) {
        if (node == null) return;
        TreeNode left = node.left, right = node.right;
        node.left = right;
        node.right = left;
        change(node.left);
        change(node.right);
    }
}
