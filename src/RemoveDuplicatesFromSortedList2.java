public class RemoveDuplicatesFromSortedList2 {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        // 比较a和b节点的下一个节点是否相等
        while (b != null && b.next != null) {
            // 如果不等ab后移
            if (a.next.val != b.next.val) {
                a = a.next;
            } else {
                // 如果相等,找到最后一个相等的位置,或者是边界
                // 然后a.next指向该位置的next
                while (b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
            }
            b = b.next;
        }
        return dummy.next;
    }
}
