public class PalindromeNumber {
    public static boolean solution(int x) {
        if (x < 0 || (x % 10 == 0 && x!=0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int reverse = 0;
        // 找出前半部分与后半部分比较
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        System.out.println(solution(-1234321));
    }
}
