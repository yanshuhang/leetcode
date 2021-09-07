import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DifferentWayToAddParentheses {
    private HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> solution(String expression) {
        if (expression == null || expression.length() == 0) {
            return Collections.emptyList();
        }
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 递归子问题
                List<Integer> leftList = solution(expression.substring(0, i));
                List<Integer> rightList = solution(expression.substring(i + 1));
                for (Integer leftValue : leftList) {
                    for (Integer rightValue : rightList) {
                        if (c == '+') {
                            ans.add(leftValue + rightValue);
                        } else if (c == '-') {
                            ans.add(leftValue - rightValue);
                        } else {
                            ans.add(leftValue * rightValue);
                        }
                    }
                }
            }
        }
        map.put(expression, ans);
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}
