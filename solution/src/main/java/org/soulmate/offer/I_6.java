package org.soulmate.offer;

public class I_6 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        int[] ints = new int[len];
        while (--len >= 0) {
            ints[len] = head.val;
            head = head.next;
        }

        return ints;
    }
}