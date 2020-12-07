public class ValidNumber {
    public boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] chars = s.trim().toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                numSeen = true;
            } else if (aChar == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (aChar == 'e' || aChar == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
                dotSeen = false;
            } else if (aChar == '-' || aChar == '+') {
                if (numSeen || dotSeen) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }
}
