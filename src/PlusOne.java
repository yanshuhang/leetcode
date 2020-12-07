public class PlusOne {
    public int[] solution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] %= 10;
            // +1后单个数字最大等于10,不等于10时不需要进位,可以直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        // for循环结束没有返回说明数组第一个数字+1=10,这里需要将数组扩充1位
        digits = new int[digits.length + 1];
        // 因为是+1,所以在加到数组第一个数字的情况下,其他位肯定都是0了
        digits[0] = 1;
        return digits;
    }
}
