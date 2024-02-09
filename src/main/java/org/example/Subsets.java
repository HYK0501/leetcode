package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> returnSubsets( int[] nums , int index  ){
        List<List<Integer>> subRes = new ArrayList<>();
        if( index == nums.length - 1){
            List<Integer> contain = new ArrayList<>();
            List<Integer> empty = new ArrayList<>();
            contain.add( nums[ index ] );
            subRes.add( contain );
            subRes.add( empty );
            return subRes;
        }else{
            List<List<Integer>> subContains = returnSubsets( nums , index + 1 );
            List<List<Integer>> subEmpty = returnSubsets( nums , index + 1 );
            for( List<Integer> subContain : subContains){
                subContain.add( nums[ index ] );
            }
            subRes.addAll( subContains );
            subRes.addAll( subEmpty );
        }
        return subRes;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return returnSubsets( nums , 0);
    }
}
