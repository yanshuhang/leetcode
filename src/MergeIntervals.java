import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] temp = new int[intervals.length][2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int min = intervals[i][0];
            int max = intervals[i][1];
            while (i != intervals.length- 1 && max >= intervals[i+1][0]) {
                if (intervals[i+1][1] > max) {
                    max = intervals[i + 1][1];
                }
                i++;
            }
            temp[index][0] = min;
            temp[index++][1] = max;
        }
        return Arrays.copyOf(temp, index);
    }
}
