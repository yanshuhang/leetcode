public class BinaryTreeUpsideDown {
    public TreeNode solution(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode res = solution(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return res;
    }
}
