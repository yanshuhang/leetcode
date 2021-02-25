import java.util.Arrays;

public class MaximumGap {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int gap = nums[i+1] - nums[i];
            res = Math.max(res, gap);
        }
        return res;
    }
}
