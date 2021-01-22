public class SortList {
    public ListNode solution(ListNode head) {
        return sort(head, null);
    }

    // 归并排序递归版: 1.通过快慢指针找到中间节点 2.分成两部分递归 3.然后两个递归返回的结果合并
    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        // 递归到单个节点时将原链表的next断开
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode l1 = sort(head, mid);
        ListNode l2 = sort(mid, tail);
        return merge(l1, l2);
    }

    // 非递归版
    public ListNode sort1(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        // 遍历一次获得链表的长度
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 将相邻单个节点两两连接,形成两个节点分段,分段内两个节点时排序的
        // 然后将相邻分段两两合并,合并形成的分段也是排序的
        // 合并log(len)次即完成排序
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            // 每一轮都从头开始,两两分段合并
            // prev: 已经合并的分段的尾节点, 用于连接下一个合并后的分段
            // curr: 遍历链表, 确定两个分段的头节点,用于合并方法:merge
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;
            // 合并两个分段
            while (curr != null) {
                // 确定第一个分段的头节点
                ListNode head1 = curr;
                // 找到第一个分段的最后一个节点
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 确定第二个分段的头节点
                ListNode head2 = curr.next;
                // 将两个分段断开
                curr.next = null;
                curr = head2;
                // 找到第二个分段的尾节点
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 将第二个分段于之后的链表断开
                // 确定下一个while循环中第一个分段的头节点
                if (curr != null) {
                    ListNode next = curr.next;
                    curr.next = null;
                    curr = next;
                }
                // 将两个链表合并,并跟已合并的分段连接起来
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummyHead.next;
    }

    // 合并两个有序数组
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy, temp1 = l1, temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummy.next;
    }
}
