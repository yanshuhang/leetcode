public class PartitionList {
    public ListNode solution(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode right = null, r_tail = null, left = null, l_tail = null;
        while (head != null) {
            if (head.val < x) {
                if (left == null) {
                    left = head;
                } else {
                    l_tail.next = head;
                }
                l_tail = head;
            } else {
                if (right == null) {
                    right = head;
                } else {
                    r_tail.next = head;
                }
                r_tail = head;
            }
            head = head.next;
        }
        if (l_tail == null) {
            return right;
        }
        if (r_tail != null) {
            r_tail.next = null;
        }
        l_tail.next = right;
        return left;
    }

    // 使用哑节点减少判断
    public ListNode solution1(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left_dummy = new ListNode(-1);
        ListNode left = left_dummy;
        ListNode right_dummy = new ListNode(-1);
        ListNode right = right_dummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = right_dummy.next;
        return left_dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 1);
        System.out.println(new PartitionList().solution(head, 0));
    }
}
