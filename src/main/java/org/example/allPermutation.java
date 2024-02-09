package org.example;

import java.util.ArrayList;
import java.util.List;

public class allPermutation {

    public List<List<Integer>> subPermute(int head  , int[] nums){
        if( head > nums.length - 1){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for( int i = head ; i < nums.length ; i ++ ){
            if( head == nums.length - 1){
                List<Integer> list = new ArrayList<>();
                for( int j = 0 ; j < nums.length ; j++){
                    list.add(nums[j]);
                }
                lists.add( list );
                return lists;
            }
            //swap
            int temp = nums[head];
            nums[head] = nums[i];
            nums[i] = temp;
            List<List<Integer>> subRes = subPermute( head + 1 , nums);
            lists.addAll(subRes);
            temp = nums[head];
            nums[head] = nums[i];
            nums[i] = temp;
        }
        return lists;
    }

    public List<List<Integer>> permute(int[] nums) {
        return subPermute(0 , nums);
    }
}
