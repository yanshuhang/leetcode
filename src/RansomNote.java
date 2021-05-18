public class RansomNote {
    public boolean solution(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] chars = new int[26];
        int ranLen = ransomNote.length();
        for (int i = 0; i < ranLen; i++) {
            chars[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0, len = magazine.length(); i < len; i++) {
            int index = magazine.charAt(i) - 'a';
            if (chars[index] != 0) {
                chars[index] --;
                ranLen--;
            }
        }
        return ranLen == 0;
    }
}
