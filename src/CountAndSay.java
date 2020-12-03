public class CountAndSay {
    public static String solution(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String before = solution(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char pre = before.charAt(0);
        for (int i = 1; i < before.length(); i++) {
            char current = before.charAt(i);
            if (current == pre) {
                count++;
            } else {
                stringBuilder.append(count).append(pre);
                count = 1;
                pre = current;
            }
            if (i == before.length() - 1) {
                stringBuilder.append(count).append(current);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(solution(i));
        }
    }
}
