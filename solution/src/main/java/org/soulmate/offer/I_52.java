package org.soulmate.offer;

public class I_52 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB)
                return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if (ptrA == ptrB)
            return null;
        if (ptrA == null) {
            ptrA = headB;
        } else {
            ptrB = headA;
        }

        while (ptrA != null && ptrB != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if (ptrA == null) {
            ptrA = headB;
        } else {
            ptrB = headA;
        }

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB)
                return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
