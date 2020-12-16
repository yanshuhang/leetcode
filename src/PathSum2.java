import java.util.*;

public class PathSum2 {
    public List<List<Integer>> solution(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(ans, path, root, sum);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }
        backtrack(ans, path, root.left, sum);
        backtrack(ans, path, root.right, sum);
        path.remove(path.size()-1);
    }
}
