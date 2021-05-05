import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum3 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> solution(int k, int n) {
        final List<List<Integer>> ans = this.ans;
        for (int mask = 0; mask < (1 << 9); mask++) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    // 使用二进制列出所有情况，遍历判断是否满足条件
    public boolean check(int mask, int k, int n) {
        final List<Integer> temp = this.temp;
        temp.clear();
        for (int i = 0; i < 9; i++) {
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum == n;
    }

    // 回溯
    public List<List<Integer>> solution1(int k, int n) {
        backtrack(1, k, 9, n);
        return ans;
    }

    public void backtrack(int cur, int k, int end, int n) {
        if (temp.size() + (end - cur + 1) < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == n) {
                ans.add(new ArrayList<>(temp));
                return;
            }
        }
        temp.add(cur);
        backtrack(cur + 1, k, end, n);
        temp.remove(temp.size() - 1);
        backtrack(cur + 1, k, end, n);
    }

    // 回溯
    public List<List<Integer>> solution2(int k, int n) {
        dfs(1, k, n);
        return ans;
    }

    public void dfs(int begin, int k, int n) {
        if (n == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < 10; i++) {
            if (n - i < 0) {
                return;
            }
            path.offer(i);
            dfs(i+1, k , n-i);
            path.removeLast();
        }
    }
}
