package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add( new int[]{ temperatures[0] , 0 } );
        for( int i = 1 ; i < temperatures.length ; i++ ){
            while( !stack.isEmpty() ){
                if( stack.peekLast()[0] >= temperatures[i] ) break;
                else{
                    int[] remove = stack.removeLast();
                    res[ remove[1] ] = i - remove[1];
                }
            }
            stack.add( new int[]{ temperatures[i] , i } );
        }
        return res;
    }
}
