import java.util.*;

public class SubSet2 {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayDeque<>(), nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, Deque<Integer> path, int[] nums, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrack(ans, path, nums, i + 1);
            path.removeLast();
        }
    }
}
