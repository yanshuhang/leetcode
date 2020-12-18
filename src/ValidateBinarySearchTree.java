public class ValidateBinarySearchTree {
    public boolean solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // 初始使用null代替Integer的最大和最小,不然无法判断
    public boolean helper(TreeNode root, Integer min, Integer max) {
        int val = root.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        if (root.left != null) {
            if (!helper(root.left, min, val)) {
                return false;
            }
        }
        if (root.right != null) {
            return helper(root.right, val, max);
        }
        return true;
    }
}
