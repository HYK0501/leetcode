package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongesConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer , Integer> startToEnd = new HashMap<>();
        Map<Integer , Integer> endToStart = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0 ; i < nums.length ; i++){
            if(set.contains(nums[i]))continue;
            set.add(nums[i]);
            Integer end = startToEnd.get( nums[i] + 1 );
            Integer start = endToStart.get( nums[i] - 1 );
            if( start!= null && end != null){
                startToEnd.put( start , end );
                endToStart.put( end , start );
            }else if( end != null ){
                endToStart.put( end , nums[i] );
                startToEnd.put( nums[i] , end );
            }else if( start != null ){
                startToEnd.put( start , nums[i] );
                endToStart.put( nums[i] , start );
            }else{
                startToEnd.put( nums[i] , nums[i] );
                endToStart.put( nums[i] , nums[i] );
            }
        }
        int max = 0;
        for( Integer start : startToEnd.keySet() ){
            int end = startToEnd.get( start );
            int temp = end - start + 1;
            if( max < temp){
                max = temp;
            }
        }
        return max;
    }
}
