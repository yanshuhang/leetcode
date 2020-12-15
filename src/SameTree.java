public class SameTree {
    public boolean solution(TreeNode p, TreeNode q) {
        return p == null ? q == null : q != null && p.val == q.val && solution(p.left, q.left) && solution(p.right, q.right);
    }
}
