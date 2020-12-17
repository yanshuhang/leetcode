import java.util.*;

public class BinaryTreePreorderTraversal {
    // 递归
    public List<Integer> solution(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }

    // 迭代
    public List<Integer> solution1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            ans.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return ans;
    }
}
