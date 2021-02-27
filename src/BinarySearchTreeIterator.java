import java.util.ArrayDeque;

public class BinarySearchTreeIterator {

    // 使用栈模拟递归
    ArrayDeque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        // 初始从root开始到最左节点压入栈中
        stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
