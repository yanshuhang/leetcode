public class RemoveDuplicatesFromSortedList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            if (a.next.val == b.next.val) {
                while (b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b;
            }
            a = a.next;
            b = b.next;
        }
        return dummy.next;
    }

    // 修改值,不修改节点指向,最后将节点断开
    // 类似与数组快慢指针中去重
    public ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 1, 2, 3, 3);
        System.out.println(new RemoveDuplicatesFromSortedList().solution(head));
    }
}
