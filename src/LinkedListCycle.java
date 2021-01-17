import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 利用set集合存储已遍历过的节点
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            node = node.next;
        }
        return false;
    }

    public boolean solution1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针,在环中快慢指针必定会遇上
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
