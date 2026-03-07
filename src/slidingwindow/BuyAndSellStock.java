package slidingwindow;

/*
LeetCode 121: 121. Best Time to Buy and Sell Stock
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BuyAndSellStock {

    /*
    Brute Force:
    Time Complexity - O(n^2)
     */
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];
                if(maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    /*
    Optimized Approach:
    Greedy and Prefix minimum tracking

    Prefix minimum tracking → keep the lowest price seen so far
    Greedy → always update the best profit immediately

    TimeComplexity - O(n) SpaceComplexity - O(1)
     */
    public static int maxProfitOptimized(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit,  price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Optimized Approach: " + maxProfitOptimized(prices));
        System.out.println("Brute Force Approach: " +maxProfitBruteForce(prices));
    }
}