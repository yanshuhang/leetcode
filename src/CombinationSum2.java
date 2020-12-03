import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> solution(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int start = 0;
        dfs(ans, cur, candidates, start, target);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            dfs(ans, cur, candidates, i + 1, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
