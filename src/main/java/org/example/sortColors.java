package org.example;

public class sortColors {
    public void sortColors(int[] nums) {
        int whiteLocation = 0;
        int blueLocation = 0;
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            if( nums[i] == 0 ){

                //if( whiteLocation < len){
                    //swap
                if( nums[whiteLocation] == 1){
                    if( blueLocation <= whiteLocation){
                        blueLocation = whiteLocation + 1;
                    }
                    nums[i] = nums[blueLocation];
                    nums[blueLocation] = 1;
                    nums[whiteLocation] = 0;
                    blueLocation ++;
                }else{
                    nums[i] = nums[whiteLocation];
                    nums[whiteLocation] = 0;
                }
                whiteLocation++;
                //}
            }else if( nums[i] == 1 ){
                if( blueLocation <= whiteLocation){
                    blueLocation = whiteLocation + 1;
                }
                nums[i] = nums[blueLocation];
                nums[blueLocation] = 1;
                blueLocation++;
            }
        }
    }
}
