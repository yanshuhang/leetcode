import java.util.Objects;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] solution(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        // 最大堆,存储数组：值和索引，数值相同时索引大的放上边，减少堆顶的出队情况
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = Objects.requireNonNull(queue.peek())[0];
        for (int i = k; i < len; i++) {
            queue.offer(new int[]{nums[i], i});
            while (Objects.requireNonNull(queue.peek())[1] <= i - k) {
                queue.poll();
            }
            ans[i-k+1] = Objects.requireNonNull(queue.peek())[0];
        }
        return ans;
    }
}
