package org.example;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if( heights.length == 1) return heights[0];
       int[] leftLess = new int[ heights.length ];
       int[] righttLess = new int[ heights.length ];
       righttLess[ heights.length-1]= heights.length;
       leftLess[0] = -1;
       for( int i = 1 ; i < heights.length ; i++ ){
           int pre = i-1;
           while( pre!= -1){
               if( heights[pre] < heights[i] ) break;
               else pre = leftLess[pre];
           }
           leftLess[i] = pre;
       }
       for( int i = heights.length-2 ; i > -1; i-- ){
            int back = i+1;
            while( back!=heights.length){
                if( heights[back] < heights[i] ) break;
                else back = leftLess[back];
            }
            leftLess[i] = back;
       }
       int res = 0;
       for( int i = 0 ; i < heights[i] ; i++) res = Math.max( res , heights[i] * ( leftLess[i] - righttLess[i] -1 ));
       return res;
    }
}
