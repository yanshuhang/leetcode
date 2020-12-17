import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
}
