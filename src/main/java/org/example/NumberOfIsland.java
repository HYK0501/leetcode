package org.example;

public class NumberOfIsland {

    public void markIsland(char[][] grid , int m , int n , int nowM , int nowN){
        int[][] fourDirection = { { 0 , 1 } , { 0 , - 1 } , { 1 , 0 } , { -1 ,0  } };
        for( int i = 0 ; i < 4 ; i++ ){
            int tempM = 0;
            int tempN = 0;
            tempM = nowM + fourDirection[i][0];
            tempN = nowN + fourDirection[i][1];
            if( tempM < m && tempN < n && tempM > -1 && tempN > -1){
                if( grid[tempM][tempN] == '1') {
                    grid[tempM][tempN] = '2';
                    markIsland( grid , m , n , tempM , tempN );
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for( int i = 0 ; i < grid.length ; i ++){
            for( int j = 0 ; j < grid[0].length ; j++){
                if( grid[i][j] == '1' ){
                    res++;
                    markIsland(grid , grid.length , grid[0].length , i , j);
                }
            }
        }
        return res;
    }
}
