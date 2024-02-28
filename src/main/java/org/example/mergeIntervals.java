package org.example;

import java.util.*;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if( ints[0] != t1[0]) return ints[0] - t1[0];
                else return ints[1] - t1[1];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for( int i = 0 ; i < intervals.length ; i++){
            if( res.isEmpty() ) res.add( intervals[i] );
            else{
                if( res.getLast()[1] <= intervals[i][0] ){
                    int[] last = res.removeLast();
                    int[] temp = new int[]{ Math.min( last[0] , intervals[i][0] ) , Math.max( last[1] , intervals[i][1] )  };
                    res.add( temp );
                }
            }
        }
        int[][] resArray = new int[ res.size() ][2];
        for( int i = 0 ; i < resArray.length ; i++) resArray[i] = res.removeFirst();
        return resArray;
    }
}
