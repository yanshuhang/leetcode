import java.util.Arrays;

public class CountPrimes {
    public int solution(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrime(int n) {
        // 暴力法: 省略部分判断
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }

    public int solution1(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().solution1(10));
    }
}
