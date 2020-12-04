public class JumpGame {
    public boolean solution(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (i >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solution1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
