package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , HashSet<Integer>> sumMapToIndex = new HashMap<>();
        sumMapToIndex.put( 0 , new HashSet<>() );
        sumMapToIndex.get(0).add(-1);
        int sum = 0;
        int res = 0;
        for( int  i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            if( sumMapToIndex.get(sum) == null) sumMapToIndex.put(sum , new HashSet<>());
            sumMapToIndex.get(sum).add(i);
            if( sumMapToIndex.get( sum - k ) != null ) {
                res = res + sumMapToIndex.get( sum - k ).size();
                if( sumMapToIndex.get( sum - k ).contains(i) ) res--;
            }
        }
        return res;
    }
}
