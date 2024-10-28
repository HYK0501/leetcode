package org.example;

import java.util.*;

public class FindKClosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int lo = 0;
            int hi = arr.length - k;
            while( lo < hi ){
                int mid = lo + ( hi - lo + 1 )/2;
                if( Math.abs( arr[mid -1 ] - x ) < Math.abs( arr[mid + k - 1 ] - x ) ) hi = mid - 1;
                else if( Math.abs( arr[mid -1 ] - x ) > Math.abs( arr[mid + k - 1 ] - x ) ) lo = mid;
                else{
                    if( arr[mid + k -1] < x ) lo = mid;
                    else hi = mid - 1;
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            for( int i = lo ; i < lo + k ; i++ ) res.add( arr[i] );
            return res;
        }
    }
}
