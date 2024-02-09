package org.example;

import java.util.ArrayList;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int back = 0;
        ArrayList<Integer> indexs = new ArrayList<>();
        indexs.add(0);
        if( nums.length == 1) return true;
        while( !indexs.isEmpty() ){
            ArrayList<Integer> nextIndexs = new ArrayList<>();
            for( Integer index : indexs){
                if( index + nums[index] > back){
                    int end = index + nums[index];
                    if( end >= nums.length -1 ) return true;
                    for( int i = back + 1 ; i <=end ; i++){
                        nextIndexs.add( i );
                    }
                    back = end;
                }
            }
            indexs = nextIndexs;
        }
        return false;
    }
}
