public class BestTimeToBuyAndSellStock {
    // 暴力法
    public int solution(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i; j < prices.length; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }

    // 记录下当天之前的最低值
    public int solution1(int[] prices) {
        int ans = 0;
        int lowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            } else {
                ans = Math.max(ans, price - lowest);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();
        System.out.println(o.solution1(prices));
    }
}
