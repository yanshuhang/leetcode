import java.util.*;

public class BinaryTreePath {

    // 层次遍历
    public List<String> solution(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<String> ans = new ArrayList<>();

        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<String> pathQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = Objects.requireNonNull(nodeQueue.poll());
            String path = Objects.requireNonNull(pathQueue.poll());
            if (node.left == null && node.right == null) {
                ans.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }

        }
        return ans;
    }

    // 深度优先遍历
    public List<String> solution1(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        dfs(root, new StringBuilder(), list);
        return list;
    }

    public void dfs(TreeNode root, StringBuilder stringBuilder, List<String> paths) {
        if (root == null) {
            return;
        }
        int oldLen = stringBuilder.length();
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(stringBuilder.toString());
        } else {
            stringBuilder.append("->");
            dfs(root.left, stringBuilder, paths);
            dfs(root.right, stringBuilder, paths);
        }
        stringBuilder.setLength(oldLen);
    }
}
