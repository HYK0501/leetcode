package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int bottom = matrix.length - 1;
        boolean nextRoad = true;
        List<Integer> res = new ArrayList<>();
        int nowI = -1;
        int nowJ = 0;
        while( nextRoad ){

            while( nowI + 1 <= right ){
                nowI++;
                res.add( matrix[nowI][nowJ] );
            }
            up++;
            while( nowJ + 1 < bottom ){
                nowJ++;
                res.add( matrix[nowI][nowJ] );
            }
            right--;
            while( nowI -1 > left ){
                nowI--;
                res.add( matrix[nowI][nowJ] );
            }
            bottom--;
            while( nowJ -1 > up ){
                nowJ--;
                res.add( matrix[nowI][nowJ] );
            }
            left++;
            if( up > bottom || left > right){
                nextRoad = false;
            }
        }
        return res;
    }
}
