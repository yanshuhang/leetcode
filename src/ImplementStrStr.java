public class ImplementStrStr {
    public static int solution(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] src = haystack.toCharArray();
        char[] tgt = needle.toCharArray();
        char first = tgt[0];
        int max = src.length - tgt.length;
        for (int i = 0; i <= max; i++) {
            if (src[i] != first) {
                while (++i <= max && src[i] != first) {
                }
            }
            if (i <= max) {
                int k = i+1;
                int end = k + tgt.length -1;
                for (int l = 1; k < end && src[k] == tgt[k]; l++, k++) {

                }
                if (k == end) {
                    return i;
                }
            }
        }
        return -1;
    }
}
