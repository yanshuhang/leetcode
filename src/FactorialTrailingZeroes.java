public class FactorialTrailingZeroes {
    public int solution(int n) {
        // 有多少个0, 取决于其中乘了多少次5, 5的倍数化为 n*5, 其中n也可能是5的倍数
        // 每隔5个数便有一个5: n/5, 每隔25个数又多一个5: n/25, 以此类推
        int ans = 0;
        while (n != 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
