import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArray2 {
    public int[] solution(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                map.put(num, count);
            }
        }
        return Arrays.copyOf(intersection, index);
    }

    // 排序 双指针
    public int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            int i1 = nums1[i];
            int i2 = nums2[j];
            if (i1 == i2) {
                intersection[index++] = i1;
                i++;
                j++;
            } else if (i1 > i2) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(intersection, index);
    }
}
