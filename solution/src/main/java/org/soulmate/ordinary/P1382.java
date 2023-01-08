package org.soulmate.ordinary;

import java.util.ArrayList;

public class P1382 {

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

    int inserted = 0;
    ArrayList<TreeNode> list;
    int[] index;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        iterate(root);

        index = new int[list.size()];
        int[] temp = new int[list.size()];
        for (int i = 0; i < temp.length; i++)
            temp[i] = i;
        divide(temp, 0, temp.length - 1);

        root = list.get(index[0]);
        for (int i = 1; i < list.size(); i++) {
            checked = false;
            changed = false;
            inserted = index[i];
            TreeNode node = search(root, list.get(inserted).val);
            if (changed && !checked)
                root = node;
        }

        return root;
    }

    private void divide(int[] array, int l, int r) {
        if (l > r)
            return;
        int m = (l + r) / 2;
        index[inserted++] = m;
        divide(array, l, m - 1);
        divide(array, m + 1, r);
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == node.right)
            return 1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    int prevHeight, prevSub;
    boolean changed = false, checked = false;

    private TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        TreeNode node;
        if (root.val > val) {
            node = search(root.left, val);
            if (node == null) {
                root.left = list.get(inserted);
                prevHeight = 2;
                prevSub = 1;
            } else {
                if (checked)
                    return root;
                if (changed) {
                    root.left = node;
                    changed = false;
                    checked = true;
                    return root;
                }
                int height = height(root.right);
                if (Math.abs(prevHeight - height) > 1) {
                    changed = true;
                    if (prevSub == 1)
                        return LL(root);
                    else
                        return LR(root);
                } else {
                    prevSub = prevHeight - height;
                    prevHeight++;
                }
            }
        } else {
            node = search(root.right, val);
            if (node == null) {
                root.right = list.get(inserted);
                prevHeight = 2;
                prevSub = -1;
            } else {
                if (checked)
                    return root;
                if (changed) {
                    root.right = node;
                    changed = false;
                    checked = true;
                    return root;
                }
                int height = height(root.left);
                if (Math.abs(height - prevHeight) > 1) {
                    changed = true;
                    if (prevSub == 1) {
                        return RL(root);
                    } else {
                        return RR(root);
                    }
                } else {
                    prevHeight++;
                    prevSub = height - prevHeight;
                }
            }
        }
        return root;
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

    private void iterate(TreeNode node) {
        if (node == null)
            return;
        iterate(node.left);
        list.add(node);
        iterate(node.right);
        node.left = null;
        node.right = null;
    }
}
