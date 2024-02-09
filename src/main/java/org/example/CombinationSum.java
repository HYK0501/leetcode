package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> getCombination( int[] candidates , int startIndesx , int target ){
        if ( candidates[startIndesx] > target){
            return null;
        }else{
            List<List<Integer>> res = new ArrayList<>();
            for( int i = startIndesx ; i < candidates.length ; i++ ){
                if( candidates[i] < target ){
                    List<List<Integer>> subRes = getCombination( candidates , i , target - candidates[i]);
                    if( subRes != null){
                        for( List<Integer> com : subRes ){
                            com.add( candidates[i] );
                        }
                        res.addAll(subRes);
                    }
                }else if( candidates[i] == target ){
                    List<Integer> temp = new ArrayList<>();
                    temp.add( candidates[i] );
                    res.add(temp);
                }
            }
            return res;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort( candidates );
        List<List<Integer>> res = getCombination(  candidates , 0 , target );
        if( res == null){
            return new ArrayList<List<Integer>>();
        }else{
            return res;
        }
    }
}
