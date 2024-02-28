package org.example;

public class hindex {
    public int hIndex(int[] citations) {
        int hi = citations.length;
        int lo = 0;
        int res = 0;
        while( hi > lo ){
            int mid = lo + ( hi - lo )/2;
            if( citations[mid] > citations.length - mid ) {
                res = citations.length - mid;
                hi = mid;
            }
            else if( citations[mid] == citations.length - mid ) return citations.length - mid;
            else lo = mid + 1;
        }
        return res;
    }
}
