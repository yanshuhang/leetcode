import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }

    public List<Integer> solution1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 将左节点全压入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出最左的节点
            root = stack.pop();
            ans.add(root.val);
            // 如果其有右节点,在下个循环中右节点会压入栈
            // 如果没有右节点,在下个循环中会弹出其父节点
            root = root.right;
        }
        return ans;
    }
}
