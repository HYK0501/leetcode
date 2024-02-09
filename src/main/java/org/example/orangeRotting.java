package org.example;

import java.util.ArrayList;

public class orangeRotting {
    public int orangesRotting(int[][] grid) {
        ArrayList<int[]> newRottings = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for( int j = 0 ; j < grid[0].length ; j++){
                if( grid[i][j] == 2 ){
                    int[] newRotting = new int[2];
                    newRotting[0] = i;
                    newRotting[1] = j;
                    newRottings.add( newRotting );
                }
            }
        }
        int[][] fourDirect = { { 1 , 0 } , { -1 , 0 } , { 0 , 1 } , { 0 , -1 } };
        int res = 0;
        while( !newRottings.isEmpty() ){
            ArrayList<int[]> nextRottings = new ArrayList<>();
            for( int[] newRotting : newRottings ){
                int m = newRotting[0];
                int n = newRotting[1];
                int tempM = m;
                int tempN = n;
                for( int i = 0 ; i < fourDirect.length ; i++){
                    tempM = m + fourDirect[i][0];
                    tempN = n + fourDirect[i][1];
                    if( tempM >= 0 && tempN >= 0 && tempM < grid.length && tempN < grid[0].length ){
                        if( grid[tempM][tempN] == 1){
                            int[] nextRotting = new int[2];
                            nextRotting[0] = tempM;
                            nextRotting[1] = tempN;
                            grid[tempM][tempN] = 2;
                            nextRottings.add( nextRotting );
                        }
                    }
                }
            }
            if( !nextRottings.isEmpty() ){
                res++;
            }
            newRottings = nextRottings;
        }
        for(int i = 0 ; i < grid.length ; i++){
            for( int j = 0 ; j < grid[0].length ; j++){
                if( grid[i][j] == 1 ){
                    return -1;
                }
            }
        }
        return res;
    }
}
