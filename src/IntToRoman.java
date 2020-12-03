public class IntToRoman {
    public static String solution(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                stringBuilder.append(romans[i]);
                num -= nums[i];
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(1994));
    }
}
