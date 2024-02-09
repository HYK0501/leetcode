package org.example;

import java.util.*;

public class MaximumProfitinJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        HashMap<Integer , Integer> closestEnds = new HashMap<>();
        HashMap<Integer , Integer> maxs = new HashMap<>();
        maxs.put(-1,0);
        ArrayList<int[]> intervals = new ArrayList<>();
        for(int i = 0 ; i < startTime.length ; i++) intervals.add( new int[] { startTime[i] , endTime[i] , profit[i] } );
        Arrays.sort( startTime ); Arrays.sort( endTime );
        int endIndex = 0;
        int lastEnd = -1;
        for(int i = 0 ; i < startTime.length ; i++){
            while ( startTime[i] >= endTime[endIndex]) {
                lastEnd = endTime[endIndex];
                endIndex++;
            }
            closestEnds.put( startTime[i] , lastEnd );
        }
        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1] - t1[1];
            }
        });
        int res = 0;
        for( int[] interval : intervals){
            int preMax = maxs.get( closestEnds.get( interval[0] ) );
            int temp = preMax + interval[2];
            if( res < temp ) res = temp;
            maxs.merge( interval[1] , res , ( old , newval ) -> {
                if( old > newval) return old;
                return newval;
            }  ); //end location's max
        }
        return res;
    }
}
