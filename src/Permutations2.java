import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(ans, cur, nums, used, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] used, int count) {
        if (count == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            dfs(ans, cur, nums, used, count+1);
            used[i] = false;
            cur.remove(count);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1};
        System.out.println(new Permutations2().solution(nums));
    }
}
