public class AddBinary {
    public String solution(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int n = Math.max(a.length(), b.length());
        char[] ans = new char[n + 1];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            temp += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            ans[n - i] = ((char) (temp % 2 + '0'));
            temp = temp / 2;
        }
        if (temp > 0) {
            ans[0] = '1';
        }
        return temp > 0 ? new String(ans) : new String(ans, 1, n);
    }

    public String solution1(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            temp += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            stringBuilder.append((char) (temp % 2 + '0'));
            temp = temp / 2;
        }
        if (temp > 0) {
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }
}
