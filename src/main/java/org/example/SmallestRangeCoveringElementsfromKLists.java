package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> allArrays = new ArrayList<>();
        for(List<Integer> list : nums){
            int[] array = new int[list.size()];
            int index = 0;
            for( int num : list){
                array[index] = num;
                index++;
            }
            allArrays.add( array );
        }
        int[] res = new int[2];
        res[1] = 10000000; res[0] = 0;
        int[] listIndexes = new int[ nums.size() ];
        int numberOfIntervalContain = 0;
        int[] kThListInQueue = new int[nums.size()];
        LinkedList<int[]> queue = new LinkedList<>();
        while( true ){
            int min = Integer.MAX_VALUE;
            int[] tempPair = new int[] { min , -1 };
            for( int i = 0 ; i < allArrays.size() ; i++ ){
                if( listIndexes[i] == allArrays.get(i).length ) continue;
                if( tempPair[0] > allArrays.get(i)[ listIndexes[i] ] ){
                    tempPair[0] = allArrays.get(i)[ listIndexes[i] ];
                    tempPair[1] = i;
                }
            }
            if( tempPair[1] == -1 ) break;
            if( listIndexes[ tempPair[1] ] == 0) numberOfIntervalContain++;
            listIndexes[ tempPair[1] ]++;
            kThListInQueue[ tempPair[1] ]++;
            if( !queue.isEmpty() ){
                while ( kThListInQueue[ queue.getFirst()[1] ] > 1 ){
                    kThListInQueue[ queue.getFirst()[1] ]--;
                    queue.removeFirst();
                    if( queue.isEmpty() ) break;
                }
            }
            queue.add( tempPair );
            if( numberOfIntervalContain == nums.size() ){
                if( queue.getLast()[0] - queue.getFirst()[0] < res[1] - res[0] ){
                    res[1] = queue.getLast()[0];
                    res[0] = queue.getFirst()[0];
                }
            }
        }
        return res;
    }
}
