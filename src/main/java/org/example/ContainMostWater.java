package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ContainMostWater {
    public int maxArea(int[] height) {
        HashMap<Integer , Integer> maxHistory = new HashMap<>();
        maxHistory.put( 0 , height[0]);
        int maxHeight = height[0];
        int max = 0;
        for(int i = 1 ; i < height.length ; i++ ){

            for( Integer locale : maxHistory.keySet() ){
                int len = i - locale;
                int cubeHeight = Math.min( height[i] , maxHistory.get( locale ) );
                int container = len*cubeHeight;
                if( max < container){
                    max = container;
                }
            }

            if( height[i] > maxHeight){
                maxHeight = height[i];
                maxHistory.put( i , height[i] );
            }
        }
        return max;
    }

}
