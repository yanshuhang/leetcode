import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle2 {
    // 在一个数组中计算
    public List<Integer> solution(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int pre = 1;
            for (int j = 1; j <= i >> 1; j++) {
                int cur = nums[j];
                nums[j] = pre + nums[j];
                nums[i-j] = nums[j];
                pre = cur;
            }
            nums[i] = 1;
        }
       return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    // 从后往前加,不需要记住nums[j-1]在更改前的值了
    public List<Integer> solution1(int rowIndex) {
        int[] nums = new int[rowIndex+1];
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                nums[j] += nums[j - 1];
            }
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PascalsTriangle2 o = new PascalsTriangle2();
        System.out.println(o.solution1(5));
    }
}
