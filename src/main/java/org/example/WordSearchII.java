package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearchII {
    HashSet<String> res;
    boolean[][] visitMap;
    char[][] board;
    public class TrieNode {
        TrieNode[] nextTries;
        boolean end;
        String word;
        TrieNode(){
            nextTries = new TrieNode[26];
            end = false;
        }
    }

    public void find(int i , int j , TrieNode[] nowTries){
        TrieNode node = nowTries[ board[i][j] - 'a'];
        visitMap[i][j] = true;
        if( node != null ){
            if( node.end ){
                res.add( node.word );
            }
            TrieNode[] nextTries = node.nextTries;
            if( i > 0 ){
                if( !visitMap[i-1][j] ) find( i-1 , j , nextTries  );
            }
            if( i < board.length-1){
                if( !visitMap[i+1][j] ) find( i+1 , j , nextTries  );
            }
            if( j > 0 ){
                if( !visitMap[i][j-1] ) find( i , j-1 , nextTries  );
            }
            if( j < board[0].length-1){
                if( !visitMap[i][j+1] ) find( i , j+1 , nextTries  );
            }
        }
        visitMap[i][j] = false;
    }


    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        visitMap = new boolean[board.length][board[0].length];
        this.board = board;
        TrieNode[] roots = new TrieNode[26];
        for(String word : words){
            TrieNode[] temps = roots;
            TrieNode node = null;
            for( int i = 0 ; i < word.length() ; i++ ){
                if( temps[ word.charAt(i) - 'a' ] == null ){
                    node = new TrieNode();
                    temps[ word.charAt(i) - 'a' ] = node;
                }else node = temps[ word.charAt(i) - 'a' ];
                temps = node.nextTries;
            }
            if(node != null) {
                node.end = true;
                node.word = word;
            }
        }
        for(int i = 0 ; i < board.length ; i ++){
            for( int j = 0 ; j < board[0].length ; j++ ){
                find(i , j , roots);
            }
        }
        return new ArrayList<>(res);
    }
}
