package org.example;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int small = 100001;
        int big = -100001;
        int gap = 0;
        for( int i = 0 ; i < prices.length ; i++ ){
            if( prices[i] < small ){
                small = prices[i];
                big = prices[i];
            }

            if( prices[i] > big ){
                big = prices[i];
                gap = big - small;
            }
        }
        return gap;
    }
}
