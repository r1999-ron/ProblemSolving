package blind_75;
/*
* ### Problem Description
- You are given an array of prices where `prices[i]` is the price of a stock on day i
- You want to maximize profit by choosing a day to buy and a later day to sell
- You can only complete one transaction (buy once and sell once)
*

### How it Works
1. Initialize variables:
    - : Keeps track of the maximum profit possible `maxProfit`
    - : Keeps track of the lowest price seen so far `minProfit`

2. For each price in the array:
    - Update if current price is lower `minProfit`
    - Calculate potential profit (current price - minimum price seen)
    - Update if the potential profit is higher `maxProfit`

### Example
For the input array `{3,2,6,5,0,3}`:
- Day 1: price = 3 → minProfit = 3, maxProfit = 0
- Day 2: price = 2 → minProfit = 2, maxProfit = 0
- Day 3: price = 6 → minProfit = 2, maxProfit = 4 (buy at 2, sell at 6)
- Day 4: price = 5 → minProfit = 2, maxProfit = 4
- Day 5: price = 0 → minProfit = 0, maxProfit = 4
- Day 6: price = 3 → minProfit = 0, maxProfit = 4

The function returns 4 as the maximum profit possible.
### Time and Space Complexity
- Time Complexity: O(n) where n is the length of the prices array
- Space Complexity: O(1) as we only use two variables regardless of input size

This is an efficient solution as it only requires a single pass through the array while maintaining the minimum price seen so far and the maximum profit possible.
/
 */
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

