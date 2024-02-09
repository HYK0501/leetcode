package org.example;

public class RotateImage {

    public void swap( int[][] matrix , int i1, int j1 , int i2 , int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotate( int[][] matrix , int whichLap ){
        for( int i = whichLap ; i < matrix.length - 1 - whichLap ; i++){
            swap( matrix , i ,  whichLap , matrix.length - whichLap - 1 , i);
            swap( matrix ,  matrix.length - whichLap - 1 , i , matrix.length - 1 - i , matrix.length - whichLap - 1);
            swap( matrix ,  matrix.length - 1 - i , matrix.length - whichLap - 1 , whichLap , matrix.length - 1 - i);
        }
        if( whichLap != matrix.length/2 ) rotate( matrix , whichLap + 1);
    }

    public void rotate(int[][] matrix) {
        rotate( matrix , 0);
    }
}
