package org.example;

import java.util.ArrayList;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int temp = 1;
        for(int i = 0 ; i < nums.length ; i++){
            answer[i] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++){
            temp = temp*nums[i-1];
            answer[i] = answer[i]*temp;
        }
        temp = 1;
        for( int i = nums.length-2 ; i > -1 ; i-- ){
            temp = temp * nums[i+1];
            answer[i] = answer[i]*temp;
        }
        return answer;
    }
}
