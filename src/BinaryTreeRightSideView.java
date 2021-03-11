import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> solution(TreeNode root) {
        // bfs 层次遍历
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = Objects.requireNonNull(deque.poll());
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (i == size) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    public List<Integer> solution1(TreeNode root) {
        // dfs 深度遍历
        // 每层遍历到的第一个加入结果集
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    /**
     *
     * @param node 当前节点
     * @param depth 当前节点深度-1
     * @param ans 结果
     */
    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        depth++;
        if (depth == ans.size() + 1) {
            ans.add(node.val);
        }
        dfs(node.right, depth, ans);
        dfs(node.left, depth, ans);
    }
}
