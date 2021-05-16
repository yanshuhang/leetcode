import java.util.ArrayList;
import java.util.List;

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

    // 两次遍历法：找到root到p和q各自的路径，比较路径最后一个相同的点就是要找的结果
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        TreeNode node = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                node = path1.get(i);
            } else {
                break;
            }
        }
        return node;
    }
    // root到目标节点的路径
    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
