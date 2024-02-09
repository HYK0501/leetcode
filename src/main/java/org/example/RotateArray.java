package org.example;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums , 0 , nums.length-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , nums.length-1);
    }
    public void reverse( int[] nums , int start , int end){
        int mid = ( start + end)/2;
        if( start >= end || end > nums.length -1 ) return;
        else if(  ( end - start + 1)%2 == 0)mid++;
        for( int i = start ; i < mid ; i++ ){
            int temp = nums[i];
            nums[i] = nums[end - i + start];
            nums[end - i + start] = temp;
        }
    }
}
