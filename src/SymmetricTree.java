import java.util.*;

public class SymmetricTree {
    public boolean solution(TreeNode root) {
        return isSame(root, root);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        return p == null ? q == null : q != null && p.val == q.val && isSame(p.right, q.left) && isSame(p.left, q.right);
    }

    public boolean solution1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            for (int i = 0; i < list.size() >> 1; i++) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(list.size() - i - 1);
                if (left == null || right == null) {
                    if (left == null && right == null) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (left.val != right.val) {
                    return false;
                }
            }
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode != null) {
                    temp.add(treeNode.left);
                    temp.add(treeNode.right);
                }
            }
            list = temp;
        }
        return true;
    }

    public boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollFirst();
            if (left == null || right == null) {
                if (left == null && right == null) {
                    continue;
                }
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            // 将需要比较的两个节点相邻放置
            deque.addLast(left.left);
            deque.addLast(right.right);
            deque.addLast(left.right);
            deque.addLast(right.left);
        }
        return true;
    }
}
