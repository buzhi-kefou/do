package org.soulmate.dataStructure;

public class AVLTree {

    // balanced binary search tree

    static class TreeNode {
        int val, height;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (root.val > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private TreeNode LL(TreeNode node) {
        // left child 1
        TreeNode left = node.left, right = left.right;
        left.right = node;
        node.left = right;
        return left;
    }

    private TreeNode LR(TreeNode node) {
        // left child -1
        TreeNode left = node.left, right = left.right;
        left.right = right.left;
        node.left = right.right;
        right.left = left;
        right.right = node;
        return right;
    }

    private TreeNode RR(TreeNode node) {
        // right child -1
        TreeNode right = node.right, left = right.left;
        right.left = node;
        node.right = left;
        return right;
    }

    private TreeNode RL(TreeNode node) {
        // right child 1
        TreeNode right = node.right, left = right.left;
        right.left = left.right;
        node.right = left.left;
        left.right = right;
        left.left = node;
        return left;
    }
}
