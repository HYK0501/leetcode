package org.example;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longArray; int[] shortArray;
        if(nums1.length > nums2.length){
            longArray = nums1;
            shortArray = nums2;
        }else{
            longArray = nums2;
            shortArray = nums1;
        }
        int sumNum = longArray.length + shortArray.length;
        int low = 0; int high = shortArray.length-1;

        while( low < high  ){
            //s1 more 1 l1 also more 1
            //binary search 要用一大 一小 把小的 或大的拉小 也等於你加了原本的 1/2 距離
            int s1 = ( low + high )/2;
            int l1 = ( longArray.length + shortArray.length + 1 )/2 - s1;
            int s2 = s1-1;
            int l2 = l1-1;
            int s2Num; int s1Num; int l1Num; int l2Num;
            if( s1 == 0 ){
                s2Num = Integer.MIN_VALUE;
            }else{
                s2Num = shortArray[ s2 ];
            }
            if( l1 == 0 ){
                l2Num = Integer.MIN_VALUE;
            }{
                l2Num = longArray[l2];
            }
            if( s1 == shortArray.length ){
                s1Num = Integer.MAX_VALUE;
            }else{
                s1Num = shortArray[s1];
            }
            if( l1 == longArray.length){
                l1Num = Integer.MAX_VALUE;
            }else{
                l1Num = longArray[l1];
            }
            if( l1Num >= s2Num && s1Num >= l2Num ){
                if( sumNum%2==0 ) return (double) ( Math.min(l1Num,s1Num) + Math.max(l2Num,s2Num) )/2;
                else return Math.max(l2Num,s2Num);
            }
            if( l1Num < s2Num ) high = s1-1;
            else if( s1Num < l2Num ) low = s1+1;
        }
        return 1;
    }
}
