public class MergeSortedArray {
    public void solution(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前放,放完之后将nums2中未放的复制过去
        int index = m + n - 1;
        int i = m-1;
        int j = n-1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
