public class SingleNumber {
    public int solution(int[] nums) {
        // 异或: 两个相同的数异或结果为0, 0和任意值异或结果为该任意值
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
