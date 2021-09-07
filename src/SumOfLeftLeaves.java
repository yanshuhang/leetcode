import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfLeftLeaves {

    public int solution(TreeNode root) {
        // 层次遍历
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeaf(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int solution1(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeaf(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeaf(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }
}
