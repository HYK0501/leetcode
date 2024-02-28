package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //if( candidates[0] > target ) return null;
        //Arrays.sort( candidates );
        ArrayList<List<List<Integer>>> ress = new ArrayList<>();
        for( int i = 0 ; i < target ; i++ ){
            ress.add( new ArrayList<>() );
            for( int j = 0 ; j < candidates.length ; j++ ){
                if( candidates[j] == i+1 ){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add( candidates[j] );
                    ress.get(i).add( temp );
                }else if( i - candidates[j] >= 0 ){
                    if( !ress.get( i - candidates[j] ).isEmpty() ){
                        for( List<Integer> list : ress.get( i - candidates[j] )  ){
                            if( list.get( list.size() - 1 ) > candidates[j]  ) continue;
                            ArrayList<Integer> temp = new ArrayList<>(list);
                            temp.add( candidates[j] );
                            ress.get(i).add( temp );
                        }
                    }
                }
            }
        }
        return ress.get( target - 1 );
    }
}
