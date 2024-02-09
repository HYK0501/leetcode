package org.example;

public class FirstMissingPositive {
    public void swap( int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while( i < nums.length ){
            if( nums[i] == i+1 || nums[i] > nums.length || nums[i] <= 0 ) i++;
            else if( nums[nums[i] - 1] != nums[i]) swap(nums , nums[i] - 1 , i);
            else i++;
        }
        i = 0;
        while( i < nums.length ) {
            if( nums[i] == i+1 ) i++;
            else break;
        }
        return i+1;
    }
}
