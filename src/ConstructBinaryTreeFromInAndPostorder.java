import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInAndPostorder {
    // 递归
    public TreeNode solution(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int size = inorder.length;
        HashMap<Integer, Integer> index_inorder = new HashMap<>();
        for (int i = 0; i < size; i++) {
            index_inorder.put(inorder[i], i);
        }
        return build(inorder, postorder, index_inorder, 0, size - 1, 0, size - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, Map<Integer, Integer> index_inorder, int in_left, int in_right, int post_left, int post_right) {
        if (post_left > post_right) {
            return null;
        }
        int rootVal = postorder[post_right];
        int root_index = index_inorder.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int left_size = root_index - in_left;
        root.left = build(inorder, postorder, index_inorder, in_left, root_index - 1, post_left, post_left + left_size - 1);
        root.right = build(inorder, postorder, index_inorder, root_index + 1, in_right, post_left + left_size, post_right - 1);
        return root;
    }

    // 迭代,反向遍历
    public TreeNode solution1(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
