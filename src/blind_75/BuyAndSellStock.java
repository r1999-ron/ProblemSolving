package blind_75;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices){
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;
        for(int price : prices){
            minProfit = Math.min(minProfit,price);
            maxProfit = Math.max(maxProfit,price-minProfit);
        }
        return maxProfit;
    }
}
