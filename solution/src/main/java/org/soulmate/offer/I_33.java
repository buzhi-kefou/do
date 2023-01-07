package org.soulmate.offer;

public class I_33 {

    public boolean verifyPostorder(int[] postorder) {
        return recursive(postorder, 0, postorder.length - 1);
    }

    private boolean recursive(int[] array, int l, int r) {
        if (l >= r)
            return true;

        int ptr = l;
        while (array[ptr] < array[r]) {
            ptr++;
        }

        int m = ptr;
        while (array[ptr] > array[r]) {
            ptr++;
        }

        return ptr == r && recursive(array, l, m - 1) && recursive(array, m, r);
    }

}
