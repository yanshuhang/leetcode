public class DeleteNodeInLinkedList {
    public void solution(ListNode node) {
        // 没有给头节点，不能遍历查找真正断开节点，只能修改当前节点值，然后替换其下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
