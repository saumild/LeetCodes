class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min = Integer.MAX_VALUE;
        
        for(int i = 0; i< prices.length;i++){
            if(prices[i]<min){
                min = Math.min(min,prices[i]);
            }
            profit = Math.max(profit,prices[i] - min);
            
        }
        return profit;
    }
}