import java.util.ArrayList;
import java.util.List;

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

}
