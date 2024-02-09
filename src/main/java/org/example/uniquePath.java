package org.example;

public class uniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for( int i = 0 ; i < m ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= n-1 ; i++ ){
            for(int j = 0 ; j < m ; j++){
                int temp = 0;
                for( int k = 0 ; k <= j ; k++){
                    temp = dp[ k ][ i-1 ] + temp;
                }
                dp[j][i] = temp;
            }
        }
        return dp[m-1][n-1];
    }
}
