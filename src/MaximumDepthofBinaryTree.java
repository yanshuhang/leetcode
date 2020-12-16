import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class MaximumDepthofBinaryTree {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution(root.left), solution(root.right)) + 1;
    }

    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = Objects.requireNonNull(deque.pollFirst());
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans++;
        }
        return ans;
    }
}
