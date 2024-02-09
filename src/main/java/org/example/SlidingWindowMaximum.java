package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        else if( k == nums.length ){
            int max = nums[0];
            for( int num : nums) max = Math.max( max , num);
            return new int[] { max };
        }else{
            int[] res = new int[ nums.length - k + 1];
            int[] preMax = new int[ nums.length ];//0 0~1 0~2 0~3 4 4~5 4~6 4~7
            int[] backMax = new int[ nums.length ];//0~3 1~3 2~3 3 4~7 5~7 6~7 7
            for( int i = 0 ; i < nums.length ; i++){
                preMax[i] = -1000000;backMax[i]=-1000000;
            }
            for( int i = k-1 ; i < nums.length ; i = i + k){
                for( int j = i ; j > i - k  ; j--){
                    if( j%k == k-1) backMax[j] = nums[j];
                    else backMax[j] = Math.max( backMax[j+1] , nums[j] );
                }
            }
            for( int i = 0 ; i < nums.length ; i++ ) {
                if (i % k == 0) preMax[i] = nums[i];
                else preMax[i] = Math.max(preMax[i - 1], nums[i]);
            }
            int index = 0;
            for(int i = k - 1 ; i < nums.length ; i++){
                if( i%k == k-1) res[index] = preMax[i];
                else res[index] = Math.max( preMax[i] , backMax[ i - k + 1] );
                index++;
            }
            return res;
        }
    }
}
