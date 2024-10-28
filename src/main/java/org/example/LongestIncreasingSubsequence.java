package org.example;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add( nums[0] );
        int res = 1;
        for( int i = 1 ; i < nums.length ; i++ ){
            int left = 0;
            int right = list.size() - 1;
            if( list.get( list.size() - 1 ) < nums[i] ) list.add( nums[i] );
            else{
                while( left < right ){
                    int mid = left + ( right - left )/2;
                    if( list.get( mid ) < nums[i] ) left = mid + 1;
                    else right = mid;
                }
                list.set( right , nums[i] );
            }
            res = Math.max( list.size() , res);
        }
        return res;
    }
}
