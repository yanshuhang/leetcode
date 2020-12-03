public class RemoveDuplicates {
    public static int solution(int[] nums) {
        int reslut = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[reslut]) {
                reslut++;
                nums[reslut] = nums[i];
            }
        }
        return reslut+1;
    }
}
