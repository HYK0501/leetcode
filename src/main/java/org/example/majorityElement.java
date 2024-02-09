package org.example;

import java.util.HashMap;

public class majorityElement {

    public int majorityElement(int[] nums) {
            int n = nums.length/2;
            HashMap<Integer , Integer> map = new HashMap<>();
            for(int i = 0 ; i < nums.length ; i++ ){
                if( !map.keySet().contains(nums[i]) ){
                    map.put(nums[i] , 1);
                }else{
                    int count = map.get(nums[i]);
                    map.replace( nums[i] , count + 1);
                    if( count + 1 >= n){
                        return nums[i];
                    }
                }
            }
            return 0;
    }
}
