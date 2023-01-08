package org.soulmate.dataStructure;

public class BinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode findMax(TreeNode node) {
        if (node.left == null)
            return node;
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.right == null)
            return null;
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
