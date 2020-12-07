import java.util.ArrayList;
import java.util.Arrays;

public class InsertIntervals {
    public int[][] solution(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 插入在区间的右侧且无交集
                if (!placed) {
                    ans.add(new int[]{left, right});
                    placed = true;
                }
                ans.add(interval);
            } else if (interval[1] < left) {
                // 插入在左侧且无交集
                ans.add(interval);
            } else {
                // 有交集,计算其并集
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!placed) {
            // for循环结束后有可能还没放入列表中
            ans.add(new int[]{left, right});
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {2,7};
        System.out.println(Arrays.deepToString(new InsertIntervals().solution(intervals, newInterval)));
    }
}
