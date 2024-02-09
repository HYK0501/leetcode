package org.example;

import java.util.ArrayList;

public class singleNumber {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> appearOne = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if( appearOne.contains(nums[i]) ){
                appearOne.remove( nums[i] );
            }else{
                appearOne.add( nums[i] );
            }
        }
        return appearOne.get(0);
    }
}
