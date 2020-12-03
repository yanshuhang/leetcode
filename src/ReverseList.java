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
