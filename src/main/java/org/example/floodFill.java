package org.example;

import java.util.ArrayList;

public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int replace = image[sr][sc];
        ArrayList<String> pathPairs = new ArrayList<>();
        ArrayList<String> colorPairs = new ArrayList<>();
        String pair = sr + " " + sc;
        pathPairs.add(pair);
        colorPairs.add(pair);
        while( !pathPairs.isEmpty() ){
            String tempPair = pathPairs.remove(0);
            String[] strNums = tempPair.split(" ");
            int row = Integer.parseInt( strNums[0] );
            int col = Integer.parseInt( strNums[1] );

            int[] ones = { 1 , -1 , 1  , -1};
            for( int i = 0 ; i < 4 ; i++){

                try{
                    int tempRow = row;
                    int tempCol = col;
                    if( i < 2 ){
                        tempRow = tempRow + ones[i];
                    }else{
                        tempCol = tempCol + ones[i];
                    }

                    if( image[tempRow][tempCol] == replace ){
                        String addPair = tempRow + " " + tempCol;
                        if( !colorPairs.contains(addPair) ){
                            System.out.println( addPair );
                            pathPairs.add( addPair );
                            colorPairs.add( addPair );
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        for( String colorIndex : colorPairs ){
            String[] strNums = colorIndex.split(" ");
            int row = Integer.parseInt( strNums[0] );
            int col = Integer.parseInt( strNums[1] );
            image[row][col] = color;
        }
        return image;
    }
}
