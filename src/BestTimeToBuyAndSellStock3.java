public class BestTimeToBuyAndSellStock3 {
    public int solution(int[] prices) {
        int len = prices.length;
        // 4个状态: 1.第一次买 2.第一次卖 3.第二次买 4.第二次卖
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        // 计算每天的4个状态的值,跟前一天比较取最大值
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, sell2 + prices[i]);
        }
        return sell2;
    }
}
