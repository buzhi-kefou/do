package org.soulmate.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class I_34 {

    class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        func(deque, root, 0, target);
        return res;
    }

    private ArrayList<List<Integer>> res = new ArrayList<>();

    private void func(ArrayDeque<TreeNode> deque, TreeNode node, int sum, int tar) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && sum + node.val == tar) {
            LinkedList<Integer> list = new LinkedList<>();
            for (TreeNode treeNode : deque) {
                list.addFirst(treeNode.val);
            }
            list.add(node.val);
            res.add(list);
        } else {
            sum += node.val;
            deque.push(node);
            func(deque, node.left, sum, tar);
            func(deque, node.right, sum, tar);
            deque.pop();
        }
    }
}
