package org.soulmate.ordinary;

import java.util.LinkedList;

public class P173 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class BSTIterator {
        LinkedList<Integer> list;

        public BSTIterator(TreeNode root) {
            list = new LinkedList<Integer>();
            recursive(root);
        }

        private void recursive(TreeNode node) {
            if (node == null)
                return;
            recursive(node.left);
            list.addLast(node.val);
            recursive(node.right);
        }

        public int next() {
            return list.removeFirst();
        }

        public boolean hasNext() {
            return list.size() > 0;
        }
    }
}
