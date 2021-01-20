import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {
    public TreeNode solution(TreeNode root) {
        // 递归
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solution(root.left);
        solution(root.right);
        return root;
    }

    public TreeNode solution1(TreeNode root) {
        // 层次遍历
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return root;
    }
}
