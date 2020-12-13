import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class LargestRectangleInHistogram {

    // 暴力法:求解每两个柱子之间的面积
    public int solution(int[] heights) {
        int ans = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, (j - i + 1) * minHeight);
            }
        }
        return ans;
    }

    // 对于每个高度,找到其最大宽度
    public int solution1(int[] heights) {
        int ans = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int left = i, right = i;
            while (left >= 1 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < len - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

    // 更快的找到每个高度对于的最大宽度
    public int solution2(int[] heights) {
        int len = heights.length;
        int[] left = findLeft(heights, len);
        int[] right = findRight(heights, len);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int width = right[i] - left[i] - 1;
            ans = Math.max(ans, width * heights[i]);
        }
        return ans;
    }

    // 一次遍历找出左边界
    public int[] findLeft(int[] heights, int len) {
        int[] left = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            int k = Objects.requireNonNull(stack.peek());
            while (k != -1 && heights[k] >= heights[i]) {
                stack.pop();
                k = Objects.requireNonNull(stack.peek());
            }
            left[i] = k;
            stack.push(i);
        }
        return left;
    }
    // 一次遍历找出右编辑
    public int[] findRight(int[] heights, int len) {
        int[] right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(len);
        for (int i = len - 1; i >= 0; i--) {
            int k = Objects.requireNonNull(stack.peek());
            while (k != len && heights[k] >= heights[i]) {
                stack.pop();
                k = Objects.requireNonNull(stack.peek());
            }
            right[i] = k;
            stack.push(i);
        }
        return right;
    }

    // 一次遍历找出左右边界
    public int solution3(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    // 不使用栈
    public int solution4(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0]= -1;
        right[len-1] = len;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            int temp = i-1;
            while (temp >= 0 && heights[temp] >= heights[i]) {
                temp = left[temp];
            }
            left[i] = temp;
        }
        for (int i = len - 2; i >= 0; i--) {
            int temp = i + 1;
            while (temp < len && heights[temp] >= heights[i]) {
                temp = right[temp];
            }
            right[i] = temp;
        }
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
        System.out.println(histogram.solution1(heights));
        System.out.println(histogram.solution(heights));
        System.out.println(histogram.solution2(heights));
        System.out.println(histogram.solution3(heights));
        System.out.println(histogram.solution4(heights));
    }
}
