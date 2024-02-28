package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class KClostestPoint {
    public int[][]  kClosest(int[][] points , int kNum) {
        PriorityQueue< int[] > maxHeap = new PriorityQueue<>( ( a , b ) -> { return b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]; } );
        int[][] res = new int[kNum][2];
        for( int[] point : points  ){
            if( maxHeap.size() > kNum ) maxHeap.add( point );
            else{
                int[] max = maxHeap.peek();
                if( max[0]*max[0] + max[1]*max[1] < point[0]*point[0] + point[1]*point[1] ){
                    maxHeap.poll();
                    maxHeap.add( point );
                }
            }
        }
        for( int i = 0 ; i < kNum ; i++ ) res[i] = maxHeap.poll();
        return res;
    }
}
