class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }
            if(prices[i]-minPrice>max){
                max=prices[i]-minPrice;
            }
        }
        return max;
        
    }
}