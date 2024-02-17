package org.example;
import java.util.LinkedList;

public class InsertNewInterval {
    public void replace(int[] newInterval , int[] replaceInterval ){
        newInterval[0] = Math.min( newInterval[0] , replaceInterval[0] );
        newInterval[1] = Math.max( newInterval[1] , replaceInterval[1] );
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList< int[] > res  = new LinkedList<>();
        int index = 0;
        for( index = 0 ; index < intervals.length ; index++ ){
            if( intervals[index][1] >  newInterval[0] ) break;
            else res.add( intervals[index] );
        }
        for(; index < intervals.length ; index++ ){
            if( ( intervals[index][1] >= newInterval[0] && intervals[index][1] <= newInterval[1] ) ) replace( newInterval, intervals[index] );
            else if( ( intervals[index][0] >= newInterval[0] && intervals[index][0] <= newInterval[1] ) ) replace( newInterval, intervals[index] );
            else if( ( intervals[index][0] <= newInterval[0] && intervals[index][1] >= newInterval[1] ) ) replace( newInterval, intervals[index] );
            else break;
        }
        res.add( newInterval );
        for(; index < intervals.length ; index++ ) res.add( intervals[index] );
        int[][] resArray = new int[ res.size() ][2];
        for( int i = 0 ; i < resArray.length ; i++ ) resArray[i] = res.get(i);
        return resArray;
    }
}
