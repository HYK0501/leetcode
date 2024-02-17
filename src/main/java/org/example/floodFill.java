package org.example;

import java.util.ArrayList;

public class floodFill {
    public void draw(int[][] image, int sr, int sc, int color){
        int originColor = image[sr][sc];
        image[sr][sc] = color;
        if( sr > 0 ) if( image[sr - 1][ sc ] == originColor ) draw( image , sr - 1 , sc , color );
        if( sr < image.length - 1 ) if( image[sr + 1 ][ sc ] == originColor ) draw( image , sr + 1 , sc , color );
        if( sc > 0 ) if( image[sr][ sc - 1 ] == originColor ) draw( image , sr , sc - 1 , color );
        if( sc < image[0].length - 1 ) if( image[sr][ sc + 1 ] == originColor ) draw( image , sr , sc + 1 , color );
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if( image[sr][sc] != color ) draw( image , sr , sc , color );
        return image;
    }
}
