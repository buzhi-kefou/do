package org.soulmate.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class I_28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int INF = 0x3f3f3f3f;
    TreeNode emptyNode = new TreeNode(INF);

    public boolean isSymmetric(TreeNode root, boolean flag) {
        if (root == null)
            return true;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = deque.pollFirst();
                if (!emptyNode.equals(poll)) {
                    deque.addLast(poll.left != null ? poll.left : emptyNode);
                    deque.addLast(poll.right != null ? poll.right : emptyNode);
                }
                list.add(poll.val);
            }
            if (!checkList(list))
                return false;
        }
        return true;
    }

    boolean checkList(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l).intValue() != list.get(r).intValue())
                return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null || right == null) || (left.val != right.val))
            return false;

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
