public class ReverseLinkedList2 {
    public ListNode solution(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        // 循环结束后,cur指向需要反转的第一个节点,pre为其前驱节点
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        // 记录下两个节点用于反转了之后将链表再连接起来
        ListNode left = pre, right = cur;
        // 循环结束后,pre指向需要反转的最后一个节点,cur指向其后置节点
        while (n > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        // m=0,1时left为null
        // 左侧连接反转后的头部
        if (left != null) {
            left.next = pre;
        } else {
            head = pre;
        }
        // 反转后的尾部连接右侧的部分
        right.next = cur;
        return head;
    }
}
