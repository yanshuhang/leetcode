public class FindMedianSortedArrays {
    public static double solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            solution(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int maxRight = 0;
                if (i == m) {
                    maxRight = nums2[j];
                } else if (j == n) {
                    maxRight = nums1[i];
                } else {
                    maxRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + maxRight) / 2.0;
            }
        }
        return 0.0;
    }
}
