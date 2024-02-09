package org.example;

import java.util.*;

public class threeSun {
    public List<List<Integer>> threeSum(int[] nums) {
        // 0 0 0
        int zeros = 0;
        List<List<Integer>> res =new ArrayList<>();
        Map<Integer , Boolean> duplicateMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for( int i = 0 ; i < nums.length ; i++){
            if( duplicateMap.keySet().contains( nums[i] ) ){
                duplicateMap.replace( nums[i] , true);
            }else{
                duplicateMap.put( nums[i] , false );
                set.add( nums[i] );
            }

            if( nums[i] == 0 ){
                zeros++;
            }
        }

        if( zeros > 3){
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add( list );
        }
        //Arrays.sort(nums);
        //System.out.println(nums[0]);
        for(Integer k : set){
            
        }
        return res;
    }
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer , Integer> nonDuplicates = new HashMap();
        for( int i = 0 ; i < nums.length ; i++ ){
            if( !nonDuplicates.keySet().contains( nums[i]) ) {
                nonDuplicates.put(nums[i] , 1);
            }else{
                nonDuplicates.replace( nums[i] , nonDuplicates.get(nums[i])+1 );
            }
        }
        //System.out.println(nonDuplicates.keySet());
        List<List<Integer>> res = new ArrayList<>();
        for( Integer i : nonDuplicates.keySet() ){
            //int iNum = nonDuplicates.get( i );
            //nonDuplicates.replace( i , iNum -1 );
            for( Integer j : nonDuplicates.keySet() ){
                int k = - ( i + j );
                //int jNum = nonDuplicates.get( j );
                if( nonDuplicates.keySet().contains(k) ){
                    //System.out.println(i);
                    //System.out.println(j);
                    //System.out.println(k);
                    List<Integer> temp = new ArrayList<>();
                    int kNum = nonDuplicates.get( k );
                    int iNum = nonDuplicates.get( i );
                    int jNum = nonDuplicates.get( j );
                    nonDuplicates.replace( i , iNum -1 );
                    temp.add(i);

                    if( nonDuplicates.get(j) > 0 ){
                        temp.add(j);
                        int tempNumj = nonDuplicates.get(j);
                        nonDuplicates.replace( j , tempNumj -1 );
                    }else{
                        nonDuplicates.replace( i , iNum);
                        //System.out.println( nonDuplicates.get(j) );
                        continue;
                    }

                    if( nonDuplicates.get(k) > 0 ){
                        temp.add(k);
                        int tempNumk = nonDuplicates.get(k);
                        nonDuplicates.replace( k , tempNumk -1);
                    }else{
                        nonDuplicates.replace( i , iNum);
                        nonDuplicates.replace( j , jNum );
                        //nonDuplicates.replace( k , kNum );
                        continue;
                    }

                    nonDuplicates.replace( i , iNum);
                    nonDuplicates.replace( j , jNum );
                    nonDuplicates.replace( k , kNum );

                    Collections.sort( temp );
                    if( !res.contains( temp ) ){
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

     */
}
