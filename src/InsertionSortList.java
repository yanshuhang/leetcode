public class InsertionSortList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummp = new ListNode(Integer.MIN_VALUE);
        dummp.next = head;
        ListNode n = head.next;
        ListNode tail = head;
        while (n != null) {
            ListNode p = dummp;
            while (n.val > p.next.val) {
                p = p.next;
            }
            if (p == tail) {
                tail = n;
            } else {
                tail.next = n.next;
                n.next = p.next;
                p.next = n;
            }
            n = tail.next;
        }
        return dummp.next;
    }

    public ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummp = new ListNode(Integer.MIN_VALUE);
        dummp.next = head;
        ListNode node = head.next;
        ListNode tail = head;
        while (node != null) {
            // 将node插入到尾部的情况单独列出来,可以省去tail前面节点的比较
            // 其他情况一样
            if (node.val > tail.val) {
                tail = node;
            } else {
                ListNode p = dummp;
                while (node.val > p.next.val) {
                    p = p.next;
                }
                tail.next = node.next;
                node.next = p.next;
                p.next = node;
            }
            node = tail.next;
        }
        return dummp.next;
    }
}
