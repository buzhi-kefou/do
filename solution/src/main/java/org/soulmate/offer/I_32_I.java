package org.soulmate.offer;

import java.util.ArrayList;

public class I_32_I {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<TreeNode> list = new ArrayList<>();
        int l = 0, r = 0;
        list.add(root);
        r++;

        while (l < r) {
            int cnt = 0;
            while (l < r) {
                TreeNode node = list.get(l++);
                if (node.left != null) {
                    list.add(node.left);
                    cnt++;
                }
                if (node.right != null) {
                    list.add(node.right);
                    cnt++;
                }
            }
            r += cnt;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }
}
