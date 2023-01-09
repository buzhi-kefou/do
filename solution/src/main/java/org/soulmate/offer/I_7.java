package org.soulmate.offer;

public class I_7 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder = null, inorder = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return preCreate(0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode preCreate(int preL, int preR, int inL, int inR) {
        if (preL > preR)
            return null;

        TreeNode root = new TreeNode(preorder[preL]);

        int ptr = inL;
        while (ptr <= inR) {
            if (inorder[ptr] == preorder[preL])
                break;
            ptr++;
        }
        int leftCount = ptr - inL;

        root.left = preCreate(preL + 1, preL + leftCount, inL, ptr - 1);
        root.right = preCreate(preL + leftCount + 1, preR, ptr + 1, inR);

        return root;
    }
}
