public class ExcelSheetColumnNumber {
    public int solution(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = ans * 26 + s.charAt(i) - 'A' + 1;
        }
        return ans;
    }
}
