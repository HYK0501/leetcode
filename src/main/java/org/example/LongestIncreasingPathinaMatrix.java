package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestIncreasingPathinaMatrix {
    int[][] dp;
    public void runLine(int[][] matrix , int i , int j ){
        int res = 1;
        int temp = 0;
        if( i > 0 ){
            if( matrix[i-1][j] > matrix[i][j] ){
                if( dp[i-1][j] == -1) runLine( matrix , i-1 , j );
                temp = dp[i-1][j]+1;
                res = Math.max(res , temp);
            }
        }
        if( i < matrix.length-1 ){
            if( matrix[i+1][j] > matrix[i][j] ){
                if( dp[i+1][j] == -1) runLine( matrix , i+1 , j );
                temp = dp[i+1][j]+1;
                res = Math.max(res , temp);
            }
        }
        if( j > 0 ){
            if( matrix[i][j-1] > matrix[i][j] ){
                if( dp[i][j-1] == -1) runLine( matrix , i , j-1 );
                temp = dp[i][j-1]+1;
                res = Math.max(res , temp);
            }
        }
        if( j < matrix[0].length-1 ){
            if( matrix[i][j+1] > matrix[i][j] ){
                if( dp[i][j+1] == -1) runLine( matrix , i , j+1 );
                temp = dp[i][j+1]+1;
                res = Math.max(res , temp);
            }
        }
        dp[i][j] = res;
    }
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        int res = 1;
        for( int i = 0 ; i < matrix.length ; i++ ){
            for( int j = 0 ; j < matrix[0].length ; j++) dp[i][j] = -1;
        }
        for( int i = 0 ; i < matrix.length ; i++ ){
            for( int j = 0 ; j < matrix[0].length ; j++){
                if( dp[i][j] == -1) runLine(matrix , i , j);
                res = Math.max( res , dp[i][j]);
            }
        }
        return res;
    }
}
