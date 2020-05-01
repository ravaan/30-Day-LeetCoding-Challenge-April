class Solution {
    public int maxProfit(int[] prices) {
        int buyp=0, sellp=0, profit=0;
        int len = prices.length;
        if(len < 2) return 0;
        buyp = prices[0];
        for(int i=0; i<len-1; i++) {
            if(prices[i+1] >= prices[i]) {
                continue;
            }
            else {
                sellp = prices[i];
                profit += sellp - buyp;
                buyp = prices[i+1];
            }
        }
        if(prices[len-1] >= prices[len-2]) {
            sellp = prices[len-1];
            profit += sellp - buyp;
        }
        return profit;
    }
}