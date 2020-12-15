import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTree2 {
    public List<TreeNode> solution(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate(start, i-1);
            List<TreeNode> rightTrees = generate(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTree2().solution(5).size());
    }
}
