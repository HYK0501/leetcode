package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] res = twoSum(nums , target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        if(target < 0){
            target = target * -1;
            for( int i = 0 ; i < nums.length ; i++){
                nums[i] = nums[i] * -1;
            }
        }

        int[] originNums = new int[ nums.length ];
        for(int i = 0 ; i < nums.length ; i++){
            originNums[i] = nums[i];
        }

        Arrays.sort( nums );
        ArrayList<Integer> smallThanTagrget = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if( nums[i] <= target){
                smallThanTagrget.add( nums[i] );
            }
        }


        Collections.sort( smallThanTagrget );
        int match = nums.length - 1;
        int[] result = new int[2];
        for( int i = 0 ; i < smallThanTagrget.size() ; i++){
            int tempSmall = smallThanTagrget.get(i);
            for( int j = match ; j >= 0 ; j--  ){
                if( tempSmall + nums[j] > target ){
                    match = j;
                }else if( tempSmall + nums[j] == target){

                    for(int k = 0 ; k < originNums.length ; k++ ){
                        if( originNums[k] == tempSmall ){
                            result[0] = k;
                        }
                    }

                    for(int k = 0 ; k < originNums.length ; k++ ){
                        if( originNums[k] == nums[j] ){
                            if( k == result[0] ){
                                continue;
                            }else{
                                result[1] = k;
                            }
                        }
                    }
                    return result;
                }else{
                    break;
                }
            }
        }
        return result;
    }
}