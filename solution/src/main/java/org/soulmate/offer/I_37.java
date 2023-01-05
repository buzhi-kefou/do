package org.soulmate.offer;

import java.util.LinkedList;

public class I_37 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Codec {
        private LinkedList<TreeNode> curr, next;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            curr = new LinkedList<>();
            next = new LinkedList<>();

            curr.add(root);
            while (!curr.isEmpty()) {
                while (!curr.isEmpty()) {
                    TreeNode node = curr.removeFirst();
                    if (node != null) {
                        builder.append(node.val);
                        next.addLast(node.left);
                        next.addLast(node.right);
                    } else {
                        builder.append("null");
                    }
                    builder.append(",");
                }
                LinkedList<TreeNode> temp = curr;
                curr = next;
                next = temp;
            }
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            if ("null".equals(split[0]))
                return null;

            int idx = 1;
            curr = new LinkedList<>();
            next = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));

            curr.add(root);
            while (!curr.isEmpty()) {
                while (!curr.isEmpty()) {
                    TreeNode parent = curr.removeFirst();
                    String left = split[idx], right = split[idx + 1];

                    if (!"null".equals(left)) {
                        TreeNode node = new TreeNode(Integer.parseInt(left));
                        parent.left = node;
                        next.addLast(node);
                    }
                    if (!"null".equals(right)) {
                        TreeNode node = new TreeNode(Integer.parseInt(right));
                        parent.right = node;
                        next.addLast(node);
                    }
                    idx += 2;
                }
                LinkedList<TreeNode> temp = curr;
                curr = next;
                next = temp;
            }
            return root;
        }
    }
}
