package org.example;

public class SquaredOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int nagativeStart = 0;
        int positievStart = 0;
        for( int i = 0 ; i < nums.length ; i++){
            if( nums[i] >= 0 ){
                nagativeStart = i -1;
                positievStart = i;
                break;
            }else if( i == nums.length - 1){
                nagativeStart = nums.length - 1;
                positievStart = nums.length;
            }
        }
        int index = 0;
        int[] newArray = new int[nums.length];
        while( (nagativeStart != -1 ) || ( positievStart != nums.length) ){
            if( (nagativeStart != -1) && ( positievStart != nums.length) ){
                if( -1* nums[nagativeStart] > nums[positievStart] ){
                    newArray[index] = nums[nagativeStart] * nums[nagativeStart];
                    nagativeStart--;
                }else{
                    newArray[index] = nums[positievStart] * nums[positievStart];
                    positievStart++;
                }
            }else if( positievStart != nums.length ){
                newArray[index] = nums[positievStart] * nums[positievStart];
                positievStart++;
            }else if( nagativeStart != -1 ){
                newArray[index] = nums[nagativeStart] * nums[nagativeStart];
                nagativeStart--;
            }
            index++;
        }
        return newArray;
    }
}
