package org.soulmate.offer;

public class I_18 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = new ListNode(-1), prev = null;
        res.next = head;

        while (head.val != val) {
            prev = head;
            head = head.next;
        }

        if (prev == null)
            res = head;
        else
            prev.next = head.next;
        return res.next;
    }
}
