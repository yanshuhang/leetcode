public class ExcelSheetColumnTitle {
    public String solution(int n) {
        // 相等于转26进制
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            n--;
            res.append((char) ('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }
}
