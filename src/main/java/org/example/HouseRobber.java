package org.example;

public class HouseRobber {

    public int rob(int[] nums) {
        if( nums.length == 1 ) return nums[0];
        else if( nums.length == 2 ) return Math.max( nums[0] , nums[1] );
        else{
            int[] lastMaxs = new int[nums.length];
            lastMaxs[0] = nums[0];
            lastMaxs[1] = nums[1];
            lastMaxs[2] = nums[0] + nums[2];
            for( int i = 3 ; i < nums.length ; i++ ) lastMaxs[i] = lastMaxs[i] + Math.max( lastMaxs[i - 2] , lastMaxs[i - 3] );
            return Math.max( lastMaxs[ lastMaxs.length - 1 ] , lastMaxs[ lastMaxs.length - 2 ] );
        }
    }
}
