public class PopulatingNextRightPointersinEachNode2 {
    public Node solution(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root;
        while (left != null) {
            Node last = null;
            Node nextLeft = null;
            for (Node p = left; p != null; p = p.next) {
                if (p.left != null) {
                    // 连接链表
                    if (last != null) {
                        last.next = p.left;
                    }
                    last = p.left;
                    // 找到下一层的左边第一个
                    if (nextLeft == null) {
                        nextLeft = p.left;
                    }
                }
                if (p.right != null) {
                    if (last != null) {
                        last.next  = p.right;
                    }
                    last = p.right;
                    if (nextLeft == null) {
                        nextLeft = p.right;
                    }
                }
            }
            left = nextLeft;
        }
        return root;
    }
}
