public class LengthOfLongestSubstring {
    public static int solution(String s) {
        // 只涉及英文字符，使用128长度的数组
        // 数组下标为字符的数值，存储的是字符上次在字符串中出现的下标
        int[] arr = new int[128];
        for (int i = 0; i < 128; i++) {
            arr[i] = -1;
        }
        int len = s.length();

        int result = 0;
        int start = 0;
        // result 存储当前最大值
        // start 不重复字符串的开始位置
        // 在碰到重复字符时，start置为该字符上次出现位置+1
        // 出现重复字符后，result会暂时变小，跟上次result比较取最大
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
            start = Math.max(start, arr[index] + 1);
            result = Math.max(result, i - start + 1);
            arr[index] = i;
        }
        return result;
    }
}
