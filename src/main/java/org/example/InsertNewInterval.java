package org.example;

import java.util.ArrayList;

public class InsertNewInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Integer> indexs = new ArrayList<>();

        if( intervals.length == 0){
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }

        for(int i = 0 ; i < intervals.length ; i++){

            if( intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0] ){
                indexs.add(i);
            }else if( intervals[i][0] >= newInterval[0] && intervals[i][1] <= newInterval[1]  ){
                indexs.add(i);
            }else if( intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]  ){
                indexs.add(i);
            }
            else if( newInterval[1] < intervals[i][0] ){
                break;
            }
        }

        int newSize = intervals.length - indexs.size() + 1;
        int resIndex = 0;
        int[][] res = new int[newSize][2];

        if( !indexs.isEmpty() ){
            int start = indexs.get(0);
            int end = indexs.get( indexs.size() -1 );
            int[] resInterval = new int[2];

            if( intervals[start][0] < newInterval[0] ){
                resInterval[0] = intervals[start][0];
            }else{
                resInterval[0] = newInterval[0];
            }

            if( intervals[end][1] > newInterval[1]){
                resInterval[1] = intervals[end][1];
            }else{
                resInterval[1] = newInterval[1];
            }

            for(int i = 0 ; i < intervals.length ; i++){
                if( start > i || i > end){
                    res[resIndex] = intervals[i];
                }else if ( start == i){
                    res[resIndex] = resInterval;
                }else if( i > start && i <= end){
                    continue;
                }
                resIndex++;
            }
        }else{
            boolean insert = true;
            for(int i = 0 ; i < intervals.length ; i++){
                if( newInterval[1] < intervals[i][0] && insert){
                    res[resIndex] = newInterval;
                    res[resIndex+1] = intervals[i];
                    resIndex = resIndex + 2;
                    insert = false;
                }else if( i == intervals.length - 1 && insert){
                    res[resIndex] =  intervals[i];
                    res[resIndex+1] =  newInterval;
                }else{
                    res[resIndex] = intervals[i];
                    resIndex++;
                }
            }
        }
        return res;
    }
}
