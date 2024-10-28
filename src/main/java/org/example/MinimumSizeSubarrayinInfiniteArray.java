package org.example;

import java.util.HashMap;

public class MinimumSizeSubarrayinInfiniteArray {
    public int minSizeSubarray(int[] nums, int target) {
        HashMap<Integer , Integer> lefts = new HashMap<>();
        HashMap<Integer , Integer> rights = new HashMap<>();
        lefts.put( 0 , -1);
        rights.put( 0 , nums.length);
        int sum = 0;
        int rightSum = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            sum = sum + nums[i];
            rightSum = rightSum + nums[ nums.length - i - 1];
            lefts.put( sum , i );
            rights.put( rightSum , nums.length - i - 1 );
        }
        int sums = target/sum*nums.length;
        target = target%sum;
        int res = Integer.MAX_VALUE;
        for( Integer key : lefts.keySet() ){
            Integer rightIndex = rights.get(  target - key  );
            if( rightIndex != null ){
                if( rightIndex > lefts.get(key) ) res = Math.min( res , nums.length - rightIndex + lefts.get(key) + 1 );
            }
            rightIndex = rights.get( sum - target - key  );
            if( rightIndex != null ){
                if( rightIndex - lefts.get( key ) - 1 > 0 ) res = Math.min( res , rightIndex - lefts.get( key ) - 1  );
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res + sums;
    }
}
