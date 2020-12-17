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

    public List<Integer> solution2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                ans.add(node.val);
                node = node.left;
            }
            // 如果左节点已到底,回溯
            node = deque.pop();
            node = node.right;
        }
        return ans;
    }
}
