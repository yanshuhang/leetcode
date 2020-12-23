public class BestTimeToBuyAndSellStock2 {
    public int solution(int[] prices) {
        int ans = 0;
        int lowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price >= lowest) {
                ans += price - lowest;
            }
            lowest = price;
        }
        return ans;
    }

    public int solution1(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock2 o = new BestTimeToBuyAndSellStock2();
        System.out.println(o.solution1(prices));
    }
}
