import java.util.*;

public class BinaryTreePostorderTraversal {
    // 递归
    public List<Integer> solution(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    public void postorder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            postorder(root.left, ans);
            postorder(root.right, ans);
            ans.add(root.val);
        }
    }
    // 迭代
    public List<Integer> solution1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 上次遍历的节点
        TreeNode prev = null;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root =root.left;
            }
            // 左节点到底后,如果没有右节点或者上次弹出的节点是右节点则当前节点可记录
            // 否则当前节点继续压入,再往其右子树找到最左节点
            root = deque.pop();
            if (root.right == null || root.right == prev) {
                ans.add(root.val);
                prev = root;
                root = null;
            } else {
                deque.push(root);
                root = root.right;
            }
        }
        return ans;
    }
}
