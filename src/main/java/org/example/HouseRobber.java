package org.example;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] maxs = new int[nums.length];
        if( nums.length == 1 ){
            return nums[0];
        }else if( nums.length == 2 ){
            if( nums[0] > nums[1] ){
                return nums[0];
            }else{
                return nums[1];
            }
        }else{
            maxs[0] = nums[0];
            if( nums[0] > nums[1] ){
                maxs[1] = nums[0];
            }else{
                maxs[1] = nums[1];
            }
            for( int i = 2 ; i < nums.length ; i++){
                if( maxs[ i - 2 ] + nums[i] > maxs[ i -1 ]  ){
                    maxs[ i ] = maxs[ i - 2 ] + nums[i];
                }else{
                    maxs[i] = maxs[ i - 1 ];
                }
            }
            return maxs[ nums.length - 1 ];
        }
    }
}
