package org.example;

import java.util.ArrayList;

public class SudokuSolver {
    boolean[][] horizontal;
    boolean[][] vertical;
    boolean[][] block;
    public boolean solve(char[][] board , int i , int j ){
        boolean res = false;
        if( board[i][j] != '.' ) {
            if( i==8 && j==8 ) return true;
            else if( i < 8) return solve( board , i + 1 , j);
            else if( i == 8 ) return solve( board , 0 , j+1 );
        }else{
            for( int num = 0 ; num < 9 ;  num++ ){
                if( !horizontal[i][ num ] && !vertical[j][ num ] && !block[ i/ 3 * 3 + j / 3][num] ){
                    board[i][j] = (char )('1' + num);
                    if( i==8 && j==8 ) return true;
                    else{
                        horizontal[i][ num ] = true;
                        vertical[j][ num] = true;
                        block[ i/ 3 * 3 + j / 3][num] = true;
                        if( i < 8 ) res = solve( board , i + 1 , j);
                        else if( i == 8 ) res = solve( board , 0 , j+1 );
                        if( res ) break;
                        horizontal[i][ num ] = false;
                        vertical[j][ num] = false;
                        block[ i/ 3 * 3 + j / 3][num] = false;
                        board[i][j] = '.';
                    }
                }
            }
        }
        return res;
    }
    public void solveSudoku(char[][] board) {
        // i/3*3 + j/3 block
        horizontal = new boolean[9][9];
        vertical = new boolean[9][9];
        block = new boolean[9][9];
        for( int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if ( board[i][j] - '1' > -1 && board[i][j] - '1' < 9) {
                    horizontal[i][board[i][j] - '1'] = true;
                    vertical[j][board[i][j] - '1'] = true;
                    block[i / 3 * 3 + j / 3][board[i][j] - '1'] = true;
                }
            }
        }
        solve( board , 0 , 0);
    }
}
