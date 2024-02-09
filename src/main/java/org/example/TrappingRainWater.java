package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class TrappingRainWater {
    public int trap(int[] height) {
        LinkedList<int[]> lefts = new LinkedList<>();
        int res = 0 , containerButton = 100000000;
        boolean first = true;
        for( int i = 1 ; i < height.length ; i++){
            if( height[i-1] >= height[i] ){
                if(first) lefts.add( new int[] { height[i-1] , i-1 } );
                lefts.add( new int[] { height[i] , i } );
                first = false;
            }
            if( height[i] > height[i-1] ){
                while( !first  ){
                    int[] left = lefts.peekLast();
                    int top = Math.min(left[0] , height[i]);
                    if(top > containerButton)res = res + (top - containerButton)*( i - left[1] - 1);
                    containerButton = top;
                    if( left[0] >= height[i] ){
                        lefts.add( new int[] { height[i] , i } );
                        break;
                    }
                    else lefts.removeLast();
                    if( lefts.isEmpty() ) first = true;
                }
            }
        }
        return res;
    }
}
