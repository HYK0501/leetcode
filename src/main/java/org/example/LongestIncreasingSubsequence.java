package org.example;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] increaseLenOfEnd = new int[ nums.length ];
        increaseLenOfEnd[0] = 1;
        int maxLen = 1;
        for( int i = 1 ; i < nums.length ; i++){
            increaseLenOfEnd[i] = 1;
            for( int j = 0 ; j < i  ; j++){
                if( nums[j] < nums[i] && increaseLenOfEnd[j] + 1 > increaseLenOfEnd[i] ){
                    increaseLenOfEnd[i] = increaseLenOfEnd[j] + 1;
                }
            }
            if( increaseLenOfEnd[i] > maxLen){
                maxLen = increaseLenOfEnd[i];
            }
        }
        return maxLen;
    }
}
