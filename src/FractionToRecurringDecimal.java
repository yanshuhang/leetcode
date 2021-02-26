import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String solution(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        // 当余重复时, 商也重复
        // 使用map记录下余对应的商在字符串位置, 当重复时插入'('即可
        StringBuilder ans = new StringBuilder();
        // 不同符号
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }
        long dividend = Math.abs(numerator);
        long divisor = Math.abs(denominator);
        ans.append(dividend / divisor);
        // 求余, 为0时返回
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return ans.toString();
        }
        // 余不为0时, 附加上小数点
        ans.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
            map.put(remainder, ans.length());
            remainder *= 10;
            ans.append(remainder / divisor);
            remainder %= divisor;
        }
        return ans.toString();
    }
}
