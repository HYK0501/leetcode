package org.example;

import java.util.*;

public class WordSearch {
    boolean exist = false;
    public void dfs(boolean[][] visited , char[][] board
            , String word , int nowChar , int x  , int y){
        visited[x][y] = true;
        if( nowChar == word.length() ){
            exist = true;
        }else{
            if( !exist && x > 0 ) {
                if( board[x-1][y] == word.charAt(nowChar) && !visited[x-1][y] ){
                    dfs( visited , board  , word , nowChar + 1 , x-1 , y);
                }
            }
            if( !exist && x < board.length-1 ) {
                if( board[x+1][y] == word.charAt(nowChar) && !visited[x+1][y] ){
                    dfs( visited , board  , word , nowChar + 1 , x+1 , y);
                }
            }
            if( !exist && y > 0 ) {
                if( board[x][y-1] == word.charAt(nowChar) && !visited[x][y-1] ){
                    dfs( visited , board  , word , nowChar + 1 , x , y-1);
                }
            }
            if( !exist && y < board[0].length-1 ) {
                if( board[x][y+1] == word.charAt(nowChar) && !visited[x][y+1] ){
                    dfs( visited , board  , word , nowChar + 1 , x , y+1);
                }
            }
        }
        visited[x][y] = false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for( int i = 0 ; i < board.length ; i++ ){
            for( int j = 0; j < board[0].length ; j++ ){
                if( exist ) return true;
                else if( board[i][j] == word.charAt(0) ) dfs( visited , board  , word , 1 , i , j );
            }
        }
        return exist;
    }
}
