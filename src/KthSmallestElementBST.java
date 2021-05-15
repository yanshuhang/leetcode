import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementBST {
    // 中序遍历
    public int solution(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
