package org.soulmate.offer;

public class I_35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node unused = new Node(0);
        unused.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            Node next = head.next;
            head.next = node;
            node.next = next;
            head = next;
        }

        if (unused.next == null)
            return null;

        Node fast = unused.next, slow;
        head = fast.next;
        while (fast != null) {
            slow = fast.next;
            if (fast.random != null)
                slow.random = fast.random.next;
            fast = slow.next;
        }

        fast = unused.next;
        slow = fast.next;

        while (fast != null) {
            Node temp = slow.next;
            fast.next = slow.next;

            if (slow.next == null)
                slow.next = null;
            else
                slow.next = slow.next.next;

            slow = slow.next;
            fast = temp;
        }

        return head;
    }
}
