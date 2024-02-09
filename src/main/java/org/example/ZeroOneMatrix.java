package org.example;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distances = new int[mat.length][mat[0].length];

        //init
        for( int i = 0 ; i < mat.length ; i++){
            for( int j = 0 ; j < mat[0].length ; j++){
                if( mat[i][j] == 0){
                    distances[i][j] = 0;
                }else{
                    distances[i][j] = 10000;
                }
            }
        }
        int max = Math.max(  mat[0].length , mat.length );
        int[][] fourLocale = { { 1 , 0} , { -1 , 0} , { 0 , 1} , { 0 , -1} };

        int nowRow;
        int nowCol;

        boolean over = false;
        int step = 0;
        while( !over ){
            over = true;
            for( int i = 0 ; i < mat.length  ; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int temp = distances[i][j];
                    if( temp == 10000 ){
                        over = false;
                    }else{
                        continue;
                    }

                    for( int z = 0 ; z < 4 ; z++){

                        nowRow = i + fourLocale[z][0];
                        nowCol = j + fourLocale[z][1];
                        if( nowRow >= mat.length || nowRow < 0){
                            continue;
                        }else if( nowCol >= mat[0].length || nowCol < 0){
                            continue;
                        }else{
                            if( distances[nowRow][nowCol] == step  ){
                                distances[i][j] = distances[nowRow][nowCol] + 1;
                            }
                        }
                    }

                }
            }
            step ++;
        }
        //}
        return distances;
    }
}
