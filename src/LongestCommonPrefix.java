public class LongestCommonPrefix {
    public static String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution(strs));
    }
}
