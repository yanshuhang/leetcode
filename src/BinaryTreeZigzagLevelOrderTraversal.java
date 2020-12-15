import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                // 放数字判断是正放还是反放
                if (node != null) {
                    if (flag) {
                        temp.addLast(node.val);
                    } else {
                        temp.addFirst(node.val);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }
}
