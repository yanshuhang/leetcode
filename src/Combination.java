import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combination {
    public List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> cur = new ArrayDeque<>();
        backtrack(ans, cur, n, k, 1);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, Deque<Integer> cur, int n, int k,int start) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n - (k- cur.size())+1; i++) {
            cur.addLast(i);
            backtrack(ans, cur, n, k, i+1);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combination().solution(4, 2));
    }
}
