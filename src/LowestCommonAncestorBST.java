public class LowestCommonAncestorBST {
    // 最近的公共父节点，必定是处于两者之间的父节点
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }
}
