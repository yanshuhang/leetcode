import java.util.*;

public class BinaryTreeLevelOrderTravesal {
    // 使用列表
    public List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode != null) {
                    temp.add(treeNode.val);
                    nodes.add(treeNode.left);
                    nodes.add(treeNode.right);
                }
            }
            if (!temp.isEmpty()) {
                ans.add(temp);
            }
            list = nodes;
        }
        return ans;
    }
}
