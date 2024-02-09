package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ValidSudoku {
    char[] numbers = {'1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9'};
    char[][] rows = new char[9][9];char[][] cols = new char[9][9];char[][] blocks = new char[9][9];
    /*
    public boolean valid(int i , int j , char[][] board){
        if( j >= 9 ){
            return true;
        }
        if( board[i][j] != '.' ){
            int number = board[i][j] - '1';
            if(  rows[i][number] > 1 || cols[j][number] > 1 || blocks[ (j/3) *3  + i/3 ][number] >  1){
                return false;
            }
            else if( i+1 < 9){
                return valid( i+1 , j ,board);
            }else{
                return valid( 0 , j+1 ,board);
            }
        }else{
            for( int number = 0 ; number < 9 ; number++ ){
                if( rows[i][number] < 1 && cols[j][number] < 1 && blocks[ (j/3) *3  + i/3 ][number] <  1){
                    board[i][j] = numbers[number];
                    rows[i][number] = 1;
                    cols[j][number] = 1;
                    blocks[ (j/3) *3  + i/3 ][number] = 1;
                    boolean res = false;
                    if( i+1 < 9){
                        res = valid( i+1 , j ,board);
                    }else{
                        res = valid( 0 , j+1 ,board);
                    }
                    if( res ){
                        return true;
                    }else{
                        rows[i][number] = 0;
                        cols[j][number] = 0;
                        blocks[ (j/3) *3  + i/3 ][number] = 0;
                    }
                }
            }
            return false;
        }
    }
     */

    public boolean isValidSudoku( char[][] board ) {

        //run nine block
        for(int i = 0 ; i < 9 ; i++){
            for( int j = 0 ; j < 3 ; j ++){
                for( int k = 0 ; k < 3 ; k++){
                    if( board[ i%3 * 3 + j  ][ i/3 * 3 + k ] != '.' ){
                        if( i == 3){
                            System.out.println( i%3 * 3 + j );
                            System.out.println( i/3 * 3 + k );
                        }
                        rows[ i%3 * 3 + j ][ board[ i%3 * 3 + j  ][ i/3 * 3 + k ] - '1' ] = 1;
                        cols[ i/3 * 3 + k ][ board[ i%3 * 3 + j  ][ i/3 * 3 + k ] - '1' ] = 1;
                        blocks[i][ board[ i%3 * 3 + j  ][ i/3 * 3 + k ] - '1' ] = 1;
                    }
                }
            }
        }
        for(int i = 0 ; i < 9 ; i++){
            for( int j = 0 ; j < 3 ; j ++){
                if( board[i][j] != '.' ){
                    int number = board[i][j] - '1';
                    if(  rows[i][number] > 1 || cols[j][number] > 1 || blocks[ (j/3) *3  + i/3 ][number] >  1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
