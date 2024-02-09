package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromePairs {
    public class TrieNode {
        TrieNode[] nextTries;
        int index;
        TrieNode(){
            nextTries = new TrieNode[26];
            index = -1;
        }
    }

    public void addNewPalindromePairs( String[] words , int i , int j , Set<List<Integer>> res ){
        StringBuilder sb = new StringBuilder( words[i] );
        sb.append( words[j] );
        if( sb.toString().equals( sb.reverse().toString() )  ) {
            res.add( Arrays.stream( new int[] { i , j }).boxed().collect(Collectors.toList()) );
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode[] roots = new TrieNode[26];
        TrieNode[] backRoots = new TrieNode[26];
        int emptyIndex = -1;
        for( int i = 0 ; i < words.length ; i++){
            TrieNode[] temps = roots;
            TrieNode node = null;
            for( int j = 0 ; j < words[i].length() ; j++){
                if( temps[ words[i].charAt(j) - 'a'] == null ) temps[ words[i].charAt(j) - 'a'] = new TrieNode();
                node = temps[ words[i].charAt(j) - 'a'];
                temps = node.nextTries;
            }
            if( node != null ) node.index = i;
            else emptyIndex = i;

            temps = backRoots;
            TrieNode backNode = null;
            for( int j = words[i].length() - 1  ; j > -1 ; j--){
                if( temps[ words[i].charAt(j) - 'a'] == null ) temps[ words[i].charAt(j) - 'a'] = new TrieNode();
                backNode = temps[ words[i].charAt(j) - 'a'];
                temps = backNode.nextTries;
            }
            if( backNode != null ) backNode.index = i;
        }
        HashSet<List<Integer>> res = new HashSet<>();
        for( int i = 0 ; i < words.length ; i++ ){
            TrieNode[] temps = roots;
            TrieNode[] backTemps = backRoots;
            String tempWord = new StringBuilder( words[i] ).reverse().toString();
            TrieNode node = null;
            TrieNode forBackNode = null;

            for( int j = 0 ; j < words[i].length() ; j++ ){
                node = temps[ tempWord.charAt(j) - 'a'];
                if( node == null ) break;
                else if( node.index != -1 ){
                    if( i != node.index ){
                        addNewPalindromePairs( words , node.index , i , res );
                    }else if( emptyIndex != -1){
                        res.add( Arrays.stream( new int[] { i , emptyIndex }).boxed().collect(Collectors.toList()) );
                        res.add( Arrays.stream( new int[] { emptyIndex , i }).boxed().collect(Collectors.toList()) );
                    }
                }
                temps = node.nextTries;
            }

            for( int j = 0 ; j < words[i].length() ; j++ ){
                forBackNode = backTemps[ words[i].charAt(j) - 'a'];
                if( forBackNode == null ) break;
                else if( forBackNode.index != -1 ){
                    if( i != forBackNode.index ){
                        addNewPalindromePairs( words , i , forBackNode.index,  res );
                    }
                }
                backTemps = forBackNode.nextTries;
            }
        }
        return new ArrayList<>(res);
    }
}
