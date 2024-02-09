package org.example;

public class FindtheDuplicateNumber {
    public int FindDuplicate(int[] nums) {
        int[] appears = new int[ nums.length ];
        for( int i = 0 ; i < nums.length ; i++){
            if( appears[ nums[i] ] == 1){
                return nums[i];
            }
            appears[ nums[i] ] = 1;
        }
        return -1;
    }
}
