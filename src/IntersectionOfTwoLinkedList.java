public class IntersectionOfTwoLinkedList {
    public ListNode solution(ListNode headA, ListNode headB) {
        // 找到两个链表的长度
        // 较长的那个从长度差开始遍历比较是否是同一个节点
        int lenA = 0;
        int lenB = 0;
        for (ListNode node = headA; node != null; node = node.next) {
            lenA++;
        }
        for (ListNode node = headB; node != null; node = node.next) {
            lenB++;
        }
        ListNode nodeA;
        ListNode nodeB;
        if (lenA < lenB) {
            nodeA = headA;
            nodeB = headB;
        } else {
            nodeA = headB;
            nodeB = headA;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            nodeB = nodeB.next;
        }
        // null 可以使用比较符号,不能使用比较方法
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public ListNode solution1(ListNode headA, ListNode headB) {
        // 双指针: 跟上面的思路一样
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA;
    }
}
