import java.util.Arrays;

public class LargestNumber {
    public String solution(int[] nums) {
        String[] numStrings = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(numStrings, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        if (numStrings[0].equals("0")) {
            return "0";
        }
        return String.join("", numStrings);
    }
}
