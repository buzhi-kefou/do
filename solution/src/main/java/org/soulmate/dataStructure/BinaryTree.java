package org.soulmate.dataStructure;

public class BinaryTree {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int[] preorder = null, inorder = null, postorder = null;

    private TreeNode preCreate(int preL, int preR, int inL, int inR) {
        if (preL >= preR)
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

    private TreeNode postCreate(int pL, int pR, int iL, int iR) {
        if (iL >= iR)
            return null;

        TreeNode root = new TreeNode(postorder[pR]);

        int pos = iL;
        while (pos <= iR) {
            if (inorder[pos] == postorder[pR])
                break;
            pos++;
        }
        int leftCount = pos - iL;

        root.left = postCreate(pL, pL + leftCount - 1, iL, pos - 1);
        root.right = postCreate(pL + leftCount, pR - 1, pos + 1, iR);

        return root;
    }
}
