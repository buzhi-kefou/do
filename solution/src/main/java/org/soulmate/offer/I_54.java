package org.soulmate.offer;

import java.util.ArrayList;

public class I_54 {

    public int kthLargest(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();
        func(root, list);
        int size = list.size();
        return list.get(size - k).val;
    }

    private void func(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null)
            return;
        func(node.left, list);
        list.add(node);
        func(node.right, list);
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
