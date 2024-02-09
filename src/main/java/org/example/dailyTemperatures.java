package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Map<Integer , LinkedList<Integer>> temperatureMapDay = new HashMap<>();
        for( int i = 0 ; i < temperatures.length ; i++){
            if( temperatureMapDay.get( temperatures[i] ) == null ){
                LinkedList<Integer> list = new LinkedList<>();
                list.addLast( i );
                temperatureMapDay.put( temperatures[i] , list );
            }else{
                temperatureMapDay.get( temperatures[i] ).add(i);
            }
            res[i] = 1000000;
        }

        for( int i = 0 ; i < temperatures.length ; i++){
            int locale = temperatureMapDay.get( temperatures[i] ).removeFirst();
            for( int j = temperatures[i] + 1 ; j < 101 ; j++ ){
                if( j > 100){
                    break;
                }else{
                    if( temperatureMapDay.get( j ) != null ){
                        if( !temperatureMapDay.get( j ).isEmpty() ){
                            int preLocale = temperatureMapDay.get( j ).getFirst();
                            if( preLocale - locale < res[i]){
                                res[i] = preLocale - locale;
                            }
                        }
                    }
                }
            }
            if( res[i] == 1000000 ){
                res[i] = 0;
            }
        }
        return res;
    }
}
