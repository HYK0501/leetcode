package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer , Integer> valueFirstIndex = new HashMap<>();
        int total = 0;
        int max = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] == 1 ) total++;
            else total--;
            if( total == 0 ) max = i + 1;
            else if( valueFirstIndex.get( total ) == null  ) valueFirstIndex.put( total , i );
            else if( valueFirstIndex.get( total ) != null ) max = Math.max( max , i -  valueFirstIndex.get( total ) );
        }
        return max;
    }
}
