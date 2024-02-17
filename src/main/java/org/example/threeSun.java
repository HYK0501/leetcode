package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class threeSun {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0 ; i < nums.length-2 ; i++){
            HashSet<Integer> set = new HashSet<>();
            int target = -nums[i];
            for( int j = 1 ; j < nums.length ; j++ ){
                if( set.contains( target - nums[j] ) ){
                    List<Integer> temp = new ArrayList<>();
                    temp.add( nums[j] );
                    temp.add( -target );
                    temp.add( target - nums[j] );
                    Collections.sort(temp);
                    res.add( temp );
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}
