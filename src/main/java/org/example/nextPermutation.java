package org.example;

public class nextPermutation {
    public void swap(int[] nums , int  i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse( int[] nums , int start , int end ){
        int len = end - start + 1;
        for( int i = 0 ; i < len/2 ; i++ ) swap( nums , start+i , end-i );
    }
    public void nextPermutation(int[] nums) {
        if( nums.length == 1) return;
        int changePoint = -1;
        for( int i = nums.length - 1 ; i > 0 ; i-- ) {
            if( nums[i] > nums[i-1] ) {
                changePoint = i - 1;
                break;
            }
        }
        if( changePoint != -1) {
            for( int i = nums.length - 1 ; i > changePoint ; i-- ) {
                if( nums[changePoint] < nums[i] ){
                    swap( nums , changePoint , i );
                    break;
                }
            }
        }
        reverse( nums , changePoint + 1 , nums.length - 1 );
    }
}
