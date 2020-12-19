import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RecoverBinarySearchTree {
    // 利用二叉搜索树的中序遍历的升序特性,找出错误的值,然后递归在树中修改错误的值
    public void solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] wrongVal = findWrongVal(list);
        fixTree(root, wrongVal, 2);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public int[] findWrongVal(List<Integer> list) {
        int size = list.size();
        int x = -1, y = -1;
        for (int i = 0; i < size - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                y = list.get(i + 1);
                if (x == -1) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void fixTree(TreeNode root, int[] wrongVal, int count) {
        if (root != null) {
            if (root.val == wrongVal[0] || root.val == wrongVal[1]) {
                root.val = root.val == wrongVal[0] ? wrongVal[1] : wrongVal[0];
                if (--count == 0) {
                    return;
                }
            }
            fixTree(root.left, wrongVal, count);
            fixTree(root.right, wrongVal, count);
        }
    }

    // 在中序遍历过程中记录下错误的值
    public void solution1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 找错错误的值
            if (pre != null && root.val < pre.val) {
                y = root;
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
