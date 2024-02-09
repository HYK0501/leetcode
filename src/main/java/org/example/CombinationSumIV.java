package org.example;

import java.util.HashMap;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target+1];
        HashMap<Integer,Integer> canUse = new HashMap<>();
        for(int num : nums) canUse.merge( num , 1 , Integer::sum );
        res[0] = 1;
        for( int i = 1; i < target+1 ; i++){
            for(int val : canUse.keySet() ){
                for( int k = 1 ; k < canUse.get(val) ; k++) {
                    int frontNum = val*k;
                    if(i >= frontNum) res[i] = res[i] + res[i-frontNum];
                    else break;
                }
            }
        }
        return res[target+1];
    }
}
