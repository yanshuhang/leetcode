import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FlattenBianryTreetoLinkedList {
    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        TreeNode prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
            prev = cur;
        }
    }

    // 前序遍历递归
    public void preorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    // 前序遍历中构建链表
    public void solution1(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode prev = null;
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = temp;
            }
            if (temp.right != null) {
                deque.push(temp.right);
            }
            if (temp.left != null) {
                deque.push(temp.left);
            }
            prev = temp;
        }
    }

    // 递归
    public void solution2(TreeNode root) {
        if (root == null) {
            return;
        }
        solution2(root.left);
        solution2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
