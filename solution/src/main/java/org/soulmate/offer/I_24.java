package org.soulmate.offer;

public class I_24 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverse = new ListNode(-1);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            ListNode next = reverse.next;
            reverse.next = node;
            node.next = next;
        }
        return reverse.next;
    }
}
