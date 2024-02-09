package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer , Integer> valueFirstIndex = new HashMap<>();
        int max = 0;
        if( nums.length == 2 ){
            if( nums[0] != nums[1] ){
                return 2;
            }
        }
        else{
            for(int i = 0 ; i < nums.length ; i++) {
                if (nums[i] == 0) nums[i] = -1;
                if( i > 0 ) nums[i] = nums[i] + nums[i-1];
                if( nums[i] == 0 ){
                    if( i+1 > max) max = i+1;
                }
                if( valueFirstIndex.get( nums[i] ) == null ){
                    valueFirstIndex.put( nums[i] , i);
                }else{
                    int temp = i = valueFirstIndex.get( nums[i] );
                    if( temp > max) max = temp;
                }
            }
        }
        return max;
    }
}
