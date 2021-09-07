public class KthLargestInArray {
    public int solution(int[] nums, int k) {
        // 使用最小堆
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = Integer.MIN_VALUE;
        }
        for (int num : nums) {
            if (num > heap[0])
                heapify(heap, num, k);
        }
        return heap[0];
    }

    public void heapify(int[] a, int key, int heapSize) {
        int half = heapSize >>> 1;
        int k = 0;
        while (k < half) {
            int child = (k << 1) + 1;
            int right = child + 1;
            int c = a[child];
            if (right < heapSize && c > a[right]) {
                c = a[child = right];
            }
            if (key < c) {
                break;
            }
            a[k] = c;
            k = child;
        }
        a[k] = key;
    }
}
