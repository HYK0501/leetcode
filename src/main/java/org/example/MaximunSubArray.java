package org.example;

public class MaximunSubArray {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[ nums.length ];
        sums[0] = nums[0];
        for( int i = 1 ; i < nums.length ; i++){
            sums[i] = nums[i] + sums[i-1];
        }
        int small = sums[0];
        int gap = 0;
        for( int i = 1 ; i < sums.length ; i++){
            if( small > sums[i] ){
                small = sums[i];
            }
            if( sums[i] - small > gap){
                gap = sums[i] - small;
            }
        }
        return gap;
    }
}
