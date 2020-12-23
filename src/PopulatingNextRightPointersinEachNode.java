import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersinEachNode {
    // 广度遍历: 遍历每一层,进行连接
    public Node solution(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pop();
                // 避免链接到下一层的节点
                if (i < size - 1) {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return root;
    }

    public Node solution1(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root;
        // 每一层遍历
        while (left.left != null) {
            Node node = left;
            // 进行下一层的连接
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            left = left.left;
        }
        return root;
    }
}
