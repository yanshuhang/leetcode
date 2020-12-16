import java.util.*;

public class BinaryTreeLevelorderTravesal2 {
    public List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> list = new ArrayDeque<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = Objects.requireNonNull(list.pollFirst());
                row.add(node.val);
                if (node.left != null) {
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                }
            }
            ans.addFirst(row);
        }
        return ans;
    }
}
