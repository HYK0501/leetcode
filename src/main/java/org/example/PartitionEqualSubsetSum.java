package org.example;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            sum = sum + nums[i];
        }
        if( sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        int[][] compeleteMatrix = new int[ target + 1][ nums.length ];
        for( int i = 0 ; i < compeleteMatrix.length ; i++ ){
            for( int j = 0 ; j < nums.length ; j++ ){
                if( i == 0 ){
                    compeleteMatrix[i][j] = 1;
                }else{
                    int tempSum = i - nums[j];
                    if( tempSum >= 0){
                        if( j > 0){
                            if( compeleteMatrix[tempSum][j-1] == 1 ){
                                compeleteMatrix[i][j] = 1;
                            }else if( compeleteMatrix[i][j-1] == 1 ){
                                compeleteMatrix[i][j] = 1;
                            }
                        }else{
                            if( tempSum == 0){
                                compeleteMatrix[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }

        for( int i = 0 ; i < nums.length ; i++ ){
            if( compeleteMatrix[target][i] == 1 ){
                return true;
            }
        }
        return false;
    }
}
