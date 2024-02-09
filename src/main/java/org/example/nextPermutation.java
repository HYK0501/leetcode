package org.example;

public class nextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int swapStartDigit = nums.length - 2;
            if( nums.length > 1){
                for(int i = nums.length - 1 ; i > 0 ; i--){
                    if( nums[i] <= nums[i-1] ){
                        swapStartDigit = i-2;
                    }else{
                        break;
                    }
                }
                if( swapStartDigit != -1 ){
                    int smallestBig = -1;
                    for( int i = swapStartDigit + 1 ; i < nums.length ; i++){
                        if( nums[i] > nums[ swapStartDigit ] ){
                            smallestBig = i;
                        }
                    }
                    if( smallestBig != -1){
                        int temp = nums[swapStartDigit];
                        nums[swapStartDigit] = nums[smallestBig];
                        nums[smallestBig] = temp;
                    }
                }
                int right = nums.length - 1;
                for(int i = swapStartDigit + 1 ; i < nums.length; i++  ){
                    int temp = nums[ right ];
                    nums[right] = nums[i];
                    nums[i] = temp;
                    right--;
                    if( right<=i+1 ){
                        break;
                    }
                }
            }
        }
    }
}
