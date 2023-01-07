package org.soulmate.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class I_32_III {
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
            boolean flag = true;
            while (!curr.isEmpty()) {
                ArrayList<Integer> item = new ArrayList<>();
                while (!curr.isEmpty()) {
                    TreeNode node = curr.removeFirst();
                    item.add(node.val);
                    if (flag) {
                        // 从左往右获取节点
                        if (node.left != null)
                            next.addFirst(node.left);
                        if (node.right != null)
                            next.addFirst(node.right);
                    } else {
                        // 从右往左获取节点
                        if (node.right != null)
                            next.addFirst(node.right);
                        if (node.left != null)
                            next.addFirst(node.left);
                    }
                }
                temp = next;
                next = curr;
                curr = temp;

                flag = !flag;
                res.add(item);
            }
        }
        return res;
    }
}
