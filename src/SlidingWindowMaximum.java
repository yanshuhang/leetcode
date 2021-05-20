import java.util.ArrayDeque;
import java.util.Deque;
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

    public int[] solution1(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        // 存储可能是最大值的索引，如果右侧有比其大的数，说明当前不可能是最大数
        for (int i = 0; i < k; i++) {
            // 去除右侧比当前值小的数
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[Objects.requireNonNull(deque.peekFirst())];
        // 窗口向右滑动
        for (int i = k; i < len; i++) {
            // 去除不可能是最大的数
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 最大的数有可能不在窗口内
            while (Objects.requireNonNull(deque.peekFirst()) <= i - k) {
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
