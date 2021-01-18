import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // set存储遍历过的节点,返回遇到的第一个已访问过的节点
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    public ListNode solution1(ListNode head) {
        // 仍然是快慢指针,需要数学证明一下,不很复杂
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }
}
