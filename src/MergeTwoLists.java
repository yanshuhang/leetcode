public class MergeTwoLists {
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode tail = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static ListNode soluton1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = soluton1(l1.next, l2);
            return l1;
        } else {
            l2.next = soluton1(l1, l2.next);
            return l2;
        }
    }
}
