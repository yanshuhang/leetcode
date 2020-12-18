import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndInorderTraversal {
    public TreeNode solution(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        int size = preorder.length;
        // 构建值和数组下标的对应,方便查找
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, indexMap, 0, size - 1, 0, size - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> indexMap, int pre_left, int pre_right, int in_left, int in_rith) {
        if (pre_left > pre_right) {
            return null;
        }
        // pre_left即根节点,找到inorder中根节点的下标
        int root_index = indexMap.get(preorder[pre_left]);
        // 构建根节点
        TreeNode root = new TreeNode(inorder[root_index]);
        // 计算根节点的左子树节点的数量,用来分割preorder
        int left_size = root_index - in_left;
        // 递归左子树和右子树
        root.left = build(preorder, inorder, indexMap, pre_left + 1, pre_left + left_size, in_left, root_index - 1);
        root.right = build(preorder, inorder, indexMap, pre_left + left_size + 1, pre_right, root_index + 1, in_rith);
        return root;
    }

    public TreeNode solution1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // 最左端的节点
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            // 找到所有左节点,构建关系
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 找完左节点,那么当前节点必是这些左节点中某个节点的右节点
                // 在中序遍历中,该节点前面的那个便是其父节点
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
