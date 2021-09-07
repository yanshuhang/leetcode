public class AddDigits {
    public int solution(int num) {
        while (num >= 10) {
            int temp = num % 10;
            num = num / 10 + temp;
        }
        return num;
    }

    public int solution1(int num) {
        return (num - 1) % 9 + 1;
    }
}
