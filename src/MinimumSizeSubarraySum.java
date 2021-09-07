public class MinimumSizeSubarraySum {
    public int solution(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                // 最终start==end，sum=0，然后跳出whiel循环，继续end+1
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int solution1(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            target -= nums[end++];
            while (target <= 0) {
                ans = Math.min(ans, end - start);
                target += nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
