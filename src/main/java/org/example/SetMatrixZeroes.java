package org.example;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int specialNum = 201;
        boolean same = true;
        while(same){
            boolean next = false;
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length ; j++){
                    if( matrix[i][j] == specialNum){
                        next = true;
                    }
                }
                if( next ) break;
            }
            if( next ) specialNum--;
            else same = false;
        }
        for(int i = 0 ; i < matrix.length ; i++)for(int j = 0 ; j < matrix[0].length ; j++)if( matrix[i][j] == 0 ) matrix[i][j] = specialNum;

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if( matrix[i][j] == specialNum ) {
                    for (int i1 = 0; i1 < matrix.length; i1++) if (matrix[i1][j] != specialNum) matrix[i1][j] = 0;
                    for (int j1 = 0; j1 < matrix[0].length; j1++) if (matrix[i][j1] != specialNum) matrix[i][j1] = 0;
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
