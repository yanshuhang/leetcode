public class NumberOfSegmentsInString {
    public int solution(String s) {
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public int solution1(String s) {
        String str = s.trim();
        if (str.equals("")) {
            return 0;
        }
        return str.split("\\s+").length;
    }
}
