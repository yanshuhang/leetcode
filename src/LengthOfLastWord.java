public class LengthOfLastWord {
    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        boolean flag = false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                flag = true;
                continue;
            }
            if (flag) {
                ans = 1;
            } else {
                ans++;
            }
            flag = false;
        }
        return ans;
    }

    public int solution1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count == 0) {
                continue;
            }
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().solution1("hello worldss"));
    }
}
