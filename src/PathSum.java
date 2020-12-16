import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class PathSum {
    // 深度递归
    public boolean solution(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        int sum1 = sum - root.val;
        return solution(root.left, sum1) || solution(root.right, sum1);
    }

    // 广度遍历
    public boolean solution1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // nodes存储遍历节点
        Deque<TreeNode> nodes = new ArrayDeque<>();
        // vals存储走到某节点的路径的和
        Deque<Integer> vals = new ArrayDeque<>();
        // 初始化根节点
        nodes.addLast(root);
        vals.addLast(root.val);
        while (!nodes.isEmpty()) {
            // 将上一轮的节点和路径和取出
            TreeNode node = nodes.pollFirst();
            int temp = Objects.requireNonNull(vals.pollFirst());
            // 如果节点是叶节点,判断是否相等
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                } else {
                    continue;
                }
            }
            if (node.left != null) {
                nodes.addLast(node.left);
                vals.addLast(temp + node.left.val);
            }
            if (node.right != null) {
                nodes.addLast(node.right);
                vals.addLast(temp + node.right.val);
            }
        }
        return false;
    }
}
