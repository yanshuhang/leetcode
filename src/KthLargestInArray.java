public class KthLargestInArray {
    public int solution(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 找出前k-1个最大数
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    // 从非叶节点开始向下调整，创建最大堆
    public void buildMaxHeap(int[] a, int heapSize) {
        int i = (heapSize >>> 1) - 1;
        for (; i >= 0; i--) {
            heapify(a, i, heapSize);
        }
    }

    // 堆节点向下调整, 遍历版本
    public void heapify(int[] a, int i, int heapSize) {
        int half = heapSize >>> 1;
        int key = a[i];
        while (i < half) {
            int child = (i << 1) + 1;
            int right = child + 1;
            int c = a[child];
            if (right < heapSize && c < a[right]) {
                c = a[child = right];
            }
            if (key > c) {
                break;
            }
            a[i] = c;
            i = child;
        }
        a[i] = key;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
