package org.example;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for( int i = 0 ; i < nums.length ; i++ ) sum = sum + nums[i];
        if( sum %2 == 1 ) return false;
        else{
            int target = sum/2;
            boolean[][] sumTable = new boolean[target][nums.length];
            for( int i = 0 ; i < target ; i++ ){
                for( int j = 0 ; j < nums.length ; j++ ){
                    if( nums[j] == i+1 ){
                        sumTable[i][j] = true;
                    }else if(i+1 > nums[j]){
                        if( j > 0 ) sumTable[i][j] = sumTable[i-nums[j]][j-1];
                    }
                    if( j > 0 ) sumTable[i][j] = sumTable[i][j] || sumTable[i][j-1];
                }
            }
            return sumTable[target-1][nums.length-1];
        }
    }
}
