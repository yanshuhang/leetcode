public class RemoveNthFromEnd {
    public static ListNode solution(ListNode head, int n) {
        // 有可能删除的是head节点，所以往前一位
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode first = dummp;
        ListNode second = dummp;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummp.next;
    }
}
