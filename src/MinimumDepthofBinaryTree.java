import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class MinimumDepthofBinaryTree {
    // 深度优先
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MIN_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, solution(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, solution(root.right));
        }
        return minDepth + 1;
    }

    // 广度优先
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            boolean flag = false;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = Objects.requireNonNull(deque.pollFirst());
                if (node.left == null && node.right == null) {
                    flag = true;
                    break;
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans++;
            if (flag) {
                break;
            }
        }
        return ans;
    }
}
