import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArray {
    public int[] solution(int[] nums1, int[] nums2) {
        // 使用map判断是否有相同的元素
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, 1);
        }
        int[] ans = new int[nums2.length];
        int index = 0;
        for (int j : nums2) {
            // 过滤重复的元素
            if (map.containsKey(j) && map.get(j) != 0) {
                ans[index++] = j;
                map.put(j, 0);
            }
        }
        return Arrays.copyOf(ans, index);
    }

    // 排序后双指针
    public int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || nums1[i] != ans[index - 1]) {
                    ans[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(ans, index);
    }
}
