class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0;
        for(int r=1;r<prices.length;r++){
            if(prices[r]>prices[l]){
                maxProfit=Math.max(maxProfit,prices[r]-prices[l]);
            }
            else{
                l=r;
            }
        }
        return maxProfit;
    }
}
