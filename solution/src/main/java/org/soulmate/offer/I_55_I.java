package org.soulmate.offer;

import java.util.LinkedList;

public class I_55_I {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> curr = new LinkedList<>(), next = new LinkedList<>();
        curr.add(root);

        //bfs
        int dept = 0;
        while (!curr.isEmpty()) {
            while (!curr.isEmpty()) {
                TreeNode node = curr.pop();
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }
            LinkedList<TreeNode> temp = curr;
            curr = next;
            next = temp;
            dept++;
        }
        return dept;
    }

    //dfs
    private int func(TreeNode node, int dept) {
        if (node == null)
            return dept;
        else
            dept++;

        int left = func(node.left, dept), right = func(node.right, dept);
        return Math.max(left, right);
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
