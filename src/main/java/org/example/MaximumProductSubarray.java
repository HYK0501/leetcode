package org.example;

import java.util.ArrayList;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int product = 1;//product is all number product after every zero of first
        int max = nums[0];
        int firstNegative = 1;
        for( int i = 0 ; i < nums.length ; i++){
            if( nums[i] != 0){
                product = product*nums[i];
                if( product < 0){
                    if( firstNegative == 1){
                        firstNegative = product;
                    }else{
                        if( max < product / firstNegative ){
                            max = product / firstNegative;
                        }
                    }
                }
                if( product > max){
                    max = product;
                }
            }else{
                firstNegative = 1;
                product = 1;
                if( max < 0){
                    max = 0;
                }
            }
        }
        return max;
    }
}
