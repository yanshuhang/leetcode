public class MultiplyStrings {
    public String solution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 记录单个数字相乘的结果
        int[] ansArr = new int[m + n];
        // 将单个数字两两相乘记录到ansArr中
        for (int i = 0; i < m; i++) {
            int x = chars1[i] - '0';
            for (int j = 0; j < n; j++) {
                int y = chars2[j] - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        // 将需要进位的向上进位
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i] % 10;
        }
        // 两数相乘的长度为m+n或者m+n-1, 找到第一个数字的位置
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        // 将数字附加到字符串中
        while (index < m + n) {
            stringBuilder.append(ansArr[index]);
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().solution("123", "456"));
    }
}
