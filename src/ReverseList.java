public class ReverseList {
    public static ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode solution1(ListNode head) {
        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = solution1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static ListNode reverseK(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        while (k > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        head.next = cur;
        return pre;
    }
    public static void main(String[] args) {
        ListNode listNode = ListNode.build(1, 2, 3, 6, 7, 8,1);
        System.out.println(reverseK(listNode, 3));
    }
}
