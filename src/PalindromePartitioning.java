import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> solution(String s) {
        if (s.length() == 0) {
            return Collections.emptyList();
        }
        List<List<String>> ans = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        backtrack(s.toCharArray(), 0, stack, ans);
        return ans;
    }

    public void backtrack(char[] chs,int start, Deque<String> path, List<List<String>> ans) {
        if (start == chs.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < chs.length; i++) {
            if (palindrome(chs, start, i)) {
                path.addLast(String.valueOf(chs, start, i+1));
                backtrack(chs, i + 1, path, ans);
                path.removeLast();
            }
        }
    }

    public boolean palindrome(char[] chs, int start, int end) {
        while (start < end) {
            if (chs[start] != chs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
