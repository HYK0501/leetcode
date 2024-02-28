package org.example;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int midLen = ( nums1.length + nums2.length)/2;
        int[] longs; int[] shorts;
        if( nums1.length < nums2.length  ){
            longs = nums2;
            shorts = nums1;
        }else{
            longs = nums2;
            shorts = nums1;
        }
        int lo = 0;
        int hi = shorts.length;
        while( lo <= hi){
            int mid = ( lo + hi)/2;
            int longP = midLen - mid;
            int preL; int postL;
            int preS; int postS;
            if( longP - 1 < 0 ) preL = Integer.MIN_VALUE;
            else preL = longs[ longP ];
            if( longP >= longs.length ) postL = Integer.MAX_VALUE;
            else postL = longs[ longP + 1 ];
            if( mid - 1 < 0 ) preS = Integer.MIN_VALUE;
            else preS = shorts[ mid - 1 ];
            if( mid >= shorts.length ) postS = Integer.MAX_VALUE;
            else postS = shorts[ mid ];
            if( postL >= preS && postS > preL){
                if( ( longs.length +  shorts.length) %2 == 0 ) return Math.max( preS, preL ) + Math.min( postL , postS);
                else return Math.max( preS , preL );
            }else if( postL < preS ) hi = mid - 1;
            else if( postS < preL ) lo = mid + 1;
        }
        return -1;
    }
}
