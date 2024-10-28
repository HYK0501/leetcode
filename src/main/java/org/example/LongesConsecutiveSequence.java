package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongesConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for( int num : nums ) set.add(num);
        int res = 0;
        for( int num : nums ){
            int temp = 1;
            if( !set.contains( num-1 ) ){
                int next = num+1;
                while( set.contains(next) ){
                    next++;
                    temp++;
                }
            }
            res = Math.max( res , temp );
        }
        return res;
    }
}
