package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort( intervals , new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) { return Integer.compare(a[0], b[0]); }
                else return Integer.compare(a[1], b[1]);
            }
        });
        int res = 0;int start = -1000000;int end = -1000000;
        for(int i = 0 ; i < intervals.length ; i++){
            if( intervals[i][0] > start ){
                if( intervals[i][1] > end){
                    if( intervals[i][0] >= end ){
                        start = intervals[i][0];
                        end = intervals[i][1];
                    }else res++;
                }else {
                    res++;
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }else {
                res++;
                if( intervals[i][1] < end ) end = intervals[i][1];
            }
        }
        return res;
    }
}
