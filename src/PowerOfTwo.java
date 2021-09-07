public class PowerOfTwo {
    // n-1将最右侧的1变为0，其低位的0变为1，如果是2的幂次方，按位与结果为0
    public boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // 总共31种情况
    public boolean solution1(int n) {
        if (n <= 0) {
            return false;
        }
        int temp = 1;
        for (int i = 1; i <= 31; i++) {
            if (n == temp) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }

    public static void main(String[] args) {
        new PowerOfTwo().solution1(16);
    }
}
