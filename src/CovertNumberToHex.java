public class CovertNumberToHex {
    public String solution(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder stringBuilder = new StringBuilder();
        // 位操作：每4位转换一次
        while (num != 0) {
            stringBuilder.append(chars[num & 0xf]);
            // 负数需要无符号右移
            num >>>= 4;
        }
        return stringBuilder.reverse().toString();
    }
}
