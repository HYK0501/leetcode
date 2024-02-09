package org.example;

import java.util.*;

public class WordSearch {
    /*
    public boolean search(int[][] boardMark ,char[][] board, String word , int nowIndexM , int nowIndexN , int wordIndex){
        if( wordIndex == word.length()){
            return true;
        }
        System.out.println( nowIndexM + "/" + nowIndexN );
        int[][] derict = { { -1 , 0 } , { 1 , 0 } , { 0 , -1 } , { 0 , 1 } };
        boardMark[nowIndexM][nowIndexN] = 1;
        for( int i = 0 ; i < 4 ; i++){
            if( ( nowIndexM + derict[i][0] >= 0) && (nowIndexM + derict[i][0] < board.length) && (nowIndexN + derict[i][1] >= 0 )&& (nowIndexN + derict[i][1] < board[0].length) ){
                boolean res = false;
                if( board[ nowIndexM + derict[i][0] ][ nowIndexN + derict[i][1] ] == word.charAt( wordIndex ) && boardMark[ nowIndexM + derict[i][0] ][ nowIndexN + derict[i][1] ]!=1 ){
                    res = search( boardMark ,  board , word ,  nowIndexM + derict[i][0] , nowIndexN + derict[i][1] , wordIndex+1);
                }
                if( res ){
                    return true;
                }
            }

        }
        boardMark[nowIndexM][nowIndexN] = 0;
        return false;
    }
     */
    /*
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        int[][] derict = { { -1 , 0 } , { 1 , 0 } , { 0 , -1 } , { 0 , 1 } };
        int[][] boardMark = new int[board.length][board[0].length];
        for( int i = 0 ; i < board.length ; i++){
            for( int j = 0 ; j < board[0].length ; j++ ){
                int[][] nextMark = new int[board.length][board[0].length];
                for( int k = 1 ; k <= word.length() ; k++){
                  if( k == 1){
                      if( board[i][j] == word.charAt(0)){
                          boardMark[i][j]=1;
                      }
                  }else{
                      if( board[i][j] == word.charAt(k-1) ){
                          for(int derectInex = 0 ; derectInex < 4 ; derectInex++ ){
                              int m = i + derict[derectInex][0];
                              int n = j + derict[derectInex][1];
                              if( m >=0 && m < board.length && n>=0 && n<board[0].length ){
                                  if( boardMark[m][n] == k-1 ){
                                      nextMark[i][j]=k;
                                  }
                              }else{
                                  nextMark[m][n]
                              }
                          }

                      }
                  }
              }
            }
        }
        return false;
    }

     */
    public boolean checkArrayIn( List<int[]> intss , int[] item){
        for(int[] ints : intss ){
            if(ints[0] == item[0] && ints[1] == item[1]){
                return true;
            }
        }
        return false;
    }


    public boolean check(String word , Map<Character , List<int[]>> boardMap , int wordIndex , int[] preStep ,List<int[]> history){
        if( wordIndex == word.length() ){
            return true;
        }
        int[][] direct = {{ 1, 0} , { -1 , 0} , { 0 , 1} , {0 , -1}};
        List<int[]> nextStepCan = boardMap.get( word.charAt( wordIndex ) ) ;
        for( int  i = 0 ; i < 4 ; i++){
            int[] temp = new int[2];
            temp[0] = preStep[0] + direct[i][0];
            temp[1] = preStep[1] + direct[i][1];
            boolean res = false;
            if( checkArrayIn(nextStepCan , temp) && !checkArrayIn(history , temp) ){
                history.add(temp);
                res = check( word , boardMap , wordIndex+1 ,  temp , history);
            }
            if(res){
                return true;
            }
        }
        history.remove( preStep );
        return false;
    }
    public boolean exist(char[][] board, String word) {
        Map<Character , List<int[]>> wordCharOfBoard = new HashMap<>();
        for(int i = 0 ; i < word.length() ; i++){
            if( wordCharOfBoard.get( word.charAt(i) ) != null ){
                continue;
            }
            for( int j = 0 ; j < board.length ; j++){
                for( int k = 0 ; k < board[0].length ; k++ ){
                    if( board[j][k] == word.charAt(i) ){
                        int[] temp = new int[2];
                        if( wordCharOfBoard.get( word.charAt(i) ) == null){
                            List<int[]> list = new ArrayList<>();
                            wordCharOfBoard.put( word.charAt(i) , list );
                        }
                        List<int[]> list = wordCharOfBoard.get( word.charAt(i) );
                        temp[0] = j;
                        temp[1] = k;
                        list.add(temp);
                    }
                }
            }
            if( wordCharOfBoard.get( word.charAt(i) ) == null ){
                return false;
            }
        }
        List<int[]> history = new ArrayList<>();
        for( int[] stepOne : wordCharOfBoard.get( word.charAt(0) )){
            history.add( stepOne );
            if( check( word ,wordCharOfBoard , 1 , stepOne , history )){
                return true;
            }
        }
        return false;
    }
}
