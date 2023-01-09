package org.soulmate.offer;

public class I_22 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
