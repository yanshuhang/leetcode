public class AddStrings {
    public String solution(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int ni = i < 0 ? 0 : num1.charAt(i) - '0';
            int nj = j < 0 ? 0 : num2.charAt(j) - '0';
            int result = ni + nj + add;
            sb.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }

}
