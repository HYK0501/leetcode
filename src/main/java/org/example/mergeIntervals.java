package org.example;

import java.util.ArrayList;
import java.util.List;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> resList = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            if( resList.isEmpty() ){
                resList.add( intervals[i] );
            }else{
                List<int[]> overlapArrays = new ArrayList<>();
                for(int[] temp : resList){
                    if( !(temp[0] > intervals[i][1] || temp[1] < intervals[i][0]) ){
                        overlapArrays.add(temp);
                    }
                }
                if( !overlapArrays.isEmpty()){
                    resList.removeAll( overlapArrays );
                    int[] newArray = new int[2];
                    int max = -1;
                    int min = 10001;
                    for( int[] temp : overlapArrays ){
                        if( temp[0] < min ){
                            min = temp[0];
                        }
                        if( temp[1] > max){
                            max = temp[1];
                        }
                    }
                    newArray[0] = min;
                    newArray[1] = max;
                    resList.add( newArray );
                }else{
                    resList.add( intervals[i] );
                }
            }
        }
        int[][] res = new int[ resList.size() ][2];
        int index = 0;
        for( int[] temp : resList ){
            res[index][0] = temp[0];
            res[index][1] = temp[1];
            index++;
        }
        return res;
        //return resList.toArray(int[]::new);
    }
}
