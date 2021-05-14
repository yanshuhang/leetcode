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
}
