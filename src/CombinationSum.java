import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> solution(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        // 排序数组
        Arrays.sort(candidates);
        // ans存储最后结果,cur存储单枝的结果
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(ans, cur, candidates, 0, target);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> cur,int[] candidates, int start, int target) {
        // 匹配后将cur列表添加到ans中
        // 注意是从cur中复制元素到新列表中
        // 然后方法返回
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 如果当前比target大,数组已排序,后面的也不会合适,中断循环 方法返回
            if (candidates[i] > target) {
                break;
            }
            // 合适就加入列表中
            cur.add(candidates[i]);
            // 然后target减去当前值继续求解
            dfs(ans, cur, candidates, i, target - candidates[i]);
            // 递归方法返回后会执行这一步
            // 两个返回方式:
            // 1.找到结果return返回
            // 2.不匹配提前中断循环break返回
            // 两个返回都需要将上一个值删除,进行下一个值的匹配
            cur.remove(cur.size() - 1);
        }
    }
}
