/**
 * RemoveLinkedListElements
 */
public class RemoveLinkedListElements {
    public ListNode solution(ListNode head, int val) {
        ListNode dummp = new ListNode();
        dummp.next = head;
        ListNode pre = dummp;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummp.next;
    }
}