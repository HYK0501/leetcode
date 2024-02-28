package org.example;

public class sortColors {
    public void swap( int i , int j , int[] nums ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int place = -1;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] == 0 ){
                place++;
                swap( place , i , nums);
            }
        }
        place = nums.length;
        for( int i = nums.length -1 ; i > -1 ; i-- ){
            if( nums[i] == 2 ){
                place--;
                swap( place , i , nums);
            }
        }
    }
}
