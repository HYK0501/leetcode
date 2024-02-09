package org.example;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    boolean[] rightSlash;
    boolean[] leftSlash;
    boolean[] vertical;
    List<List<String>> res;
    int[] board;

    int slashNumber;

    public void makeResult(){
        ArrayList<String> sbs = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for( int j = 0 ; j < board.length ; j++ ){
                if( j != board[i] ) sb.append(".");
                else sb.append("Q");
            }
            sbs.add(sb.toString());
        }
        res.add(sbs);
    }

    public void solve( int i ){ //ith horizon
        for( int j = 0 ; j < board.length ; j++ ){
            if( !vertical[j] ){
                boolean right = false;
                boolean left = false;
                if( i+j > 0 && i+j < slashNumber+1 ) {
                    if( rightSlash[ i+j-1 ] ) continue;
                    else right = true;
                }
                if( j - i + ( slashNumber / 2) > -1 &&  j - i + ( slashNumber / 2) < slashNumber  ){
                    if( leftSlash[ j - i + ( slashNumber / 2) ] ) continue;
                    else left = true;
                }
                vertical[j] = true;
                if( right ) rightSlash[ i+j-1 ] = true;
                if( left ) leftSlash[ j - i + ( slashNumber / 2) ] = true;
                board[i] = j;
                if( i == board.length - 1 ) makeResult();
                else solve(i+1 );
                vertical[j] = false;
                if( right ) rightSlash[ i+j-1 ] = false;
                if( left ) leftSlash[ j - i + ( slashNumber / 2) ] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        //all slash lines number is l
        res = new ArrayList<>();
        if( n==1 ) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("Q");
            res.add( temp );
        }else{
            slashNumber = 1 + ( n-2 )*2;
            rightSlash = new boolean[ slashNumber  ]; // i+j = k => k-1 is true in kth slash ( from the leftup is 1th -> 2th ...)
            leftSlash = new boolean[ slashNumber ]; // j - i = k - ( l/2 )  => is kth line
            vertical = new boolean[n];
            board = new int[n];
            solve(0);
        }
        return res;
    }
}
