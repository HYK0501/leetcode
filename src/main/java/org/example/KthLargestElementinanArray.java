package org.example;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int small = 100000; int big = -100000;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] < small ) small = nums[i];
            if( nums[i] > big ) big = nums[i];
        }
        int[] counts = new int[ big - small + 1 ];
        for( int i = 0 ; i < nums.length ; i++){
            counts[ nums[i] - small ]++;
        }
        int count = 0;
        for( int i = counts.length -1 ; i >= 0 ; i-- ){
            count = count + counts[i];
            if( count >= k) return i + small;
        }
        return -1;
    }
}
