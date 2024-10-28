package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int xSteps = matrix[0].length;
        int ySteps = matrix.length - 1;
        int x = -1; int y = 0;
        while( true ){
            if( xSteps == 0 ) break;
            for( int i = 0 ; i < xSteps ; i++  ){
                x++;
                list.add( matrix[y][x] );
            }
            xSteps--;
            if( ySteps == 0 ) break;
            for( int i = 0 ; i < ySteps ; i++ ){
                y++;
                list.add( matrix[y][x] );
            }
            ySteps--;
            if( xSteps == 0 ) break;
            for( int i = 0 ; i < xSteps ; i++  ){
                x--;
                list.add( matrix[y][x] );
            }
            xSteps--;
            if( ySteps == 0 ) break;
            for( int i = 0 ; i < ySteps ; i++ ){
                y--;
                list.add( matrix[y][x] );
            }
            ySteps--;
        }
        return list;
    }
}
