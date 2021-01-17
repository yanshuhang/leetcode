import entity.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node solution(Node head) {
        // 建立原node的复制,使用map记录对应关系
        // 然后建立新node的链表
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            Node node_copy = new Node(node.val, null, null);
            map.put(node, node_copy);
            node = node.next;
        }
        node = head;
        // 建立新链表
        while (node != null) {
            Node node_copy = map.get(node);
            node_copy.next = map.get(node.next);
            node_copy.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public Node solution1(Node head) {
        // 在原链表的基础上建立原node和复制node的对应关系
        // 然后建立复制node的链表
        if (head == null) {
            return null;
        }
        Node node = head;
        // 遍历链表, 将复制node置于原node的next节点
        while (node != null) {
            Node node_copy = new Node(node.val, node.next, null);
            node.next = node_copy;
            node = node_copy.next;
        }
        // 建立新链表
        node = head;
        // 首先建立random节点
        while (node != null) {
            node.next.random = (node.random == null) ? null : node.random.next;
            node = node.next.next;
        }
        // 建立next节点,并符合原链表
        Node head_copy = head.next;
        Node node_copy = head.next;
        node = head;
        while (node != null) {
            node.next = node.next.next;
            node_copy.next = (node_copy.next == null) ? null : node_copy.next.next;
            node = node.next;
            node_copy = node_copy.next;
        }
        return head_copy;
    }
}
