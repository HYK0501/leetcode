package org.example;

public class missingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int res = ( length*(1+length))/2;
        for( int i = 0 ; i < nums.length ; i++){
            res = res - nums[i];
        }
        return res;
    }
}
