public class SwapNodesPairs {
    public static ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nnext = next.next;
            next.next = nnext.next;
            nnext.next = next;
            cur.next = nnext;
            cur = next;
        }
        return dummy.next;
    }
}
