public class TrappingRainWater {
    public int solution(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        for (int i = 0; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int solution1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public int solution2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right) {
            int l_val = height[left];
            int r_val = height[right];
            if (l_val < r_val) {
                if (left_max <= l_val) {
                    left_max = l_val;
                } else {
                    ans += (left_max - l_val);
                }
                left++;
            } else {
                if (right_max <= r_val) {
                    right_max = r_val;
                } else {
                    ans += (right_max - r_val);
                }
                right--;
            }
        }
        return ans;
    }
}
