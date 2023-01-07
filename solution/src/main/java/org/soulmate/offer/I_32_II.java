package org.soulmate.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class I_32_II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (root != null) {
            LinkedList<TreeNode> curr = new LinkedList<>(), next = new LinkedList<>(), temp;

            curr.add(root);
            while (!curr.isEmpty()) {
                ArrayList<Integer> item = new ArrayList<>();
                while (!curr.isEmpty()) {
                    TreeNode node = curr.removeFirst();
                    item.add(node.val);

                    if (node.left != null)
                        next.addLast(node.left);
                    if (node.right != null)
                        next.addLast(node.right);
                }
                temp = next;
                next = curr;
                curr = temp;

                res.add(item);
            }
        }
        return res;
    }
}
