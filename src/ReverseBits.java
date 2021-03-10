public class ReverseBits {
    public int solution(int n) {
        // 取模求和
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }

    public int solution1(int n) {
        int ans = 0;
        for (int i = 32; i > 0; i--) {
            ans += (n & 1) << i;
            n >>= 1;
        }
        return ans;
    }

    public static int solution2(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(Integer.reverse(-10)));
        System.out.println(Integer.toBinaryString(new ReverseBits().solution(-10)));
        System.out.println(Integer.toBinaryString(solution2(-10)));
        System.out.println(Integer.toBinaryString(-10 << 16));
        System.out.println(Integer.toBinaryString(-10 >>> 16));
    }
}
