package org.example;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroTag = -1;
        for( int i = 0 ; i < nums.length ; i++){
            if( nums[i] == 0 ){
                if( zeroTag == -1){
                    zeroTag = i;
                }
                else{
                    continue;
                }
            }
            else{
                if( zeroTag != -1){
                    int temp = nums[i];
                    nums[i] = 0;
                    nums[zeroTag] = temp;
                    zeroTag++;
                }
            }
        }
    }
}
