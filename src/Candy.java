public class Candy {
    public int solution(int[] ratings) {
        int[] candys = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            } else {
                candys[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candys[i];
        }
        return sum;
    }

    public int solution1(int[] ratings) {
        // 在第二次遍历时计算总和
        int[] candys = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            } else {
                candys[i] = 1;
            }
        }
        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
            sum += candys[i];
        }
        return sum;
    }

    public int solution2(int[] ratings) {
        // 不需要额外空间且只需要一次遍历
        int sum = 1;
        int dec = 0, inc = 1;
        int pre = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                sum += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                sum += dec;
                pre = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 3, 5, 5, 3, 2, 1};
        System.out.println(new Candy().solution1(ratings));
    }
}
