import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement2 {
    public List<Integer> solution(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
        int n = nums.length / 3;
        return map.entrySet().stream().filter(e -> e.getValue() > n).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<Integer> solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        int cand1 = nums[0];
        int cand2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
                continue;
            }
            if (num == cand2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        int n = nums.length / 3;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            }
        }
        if (count1 > n) {
            ans.add(cand1);
        }
        if (count2 > n) {
            ans.add(cand2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new MajorityElement2().solution1(nums));
    }
}
