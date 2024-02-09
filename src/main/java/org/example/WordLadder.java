package org.example;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        LinkedList<String> dequeue = new LinkedList<>();
        Set<String> inBuildTree = new HashSet<>();
        inBuildTree.add( beginWord );dequeue.add(beginWord);
        int changes = 1;boolean havePath = false;
        for(String word : wordList) words.add(word);
        if(!words.contains(endWord))return 0;
        while( !dequeue.isEmpty() ){
            LinkedList<String> nextDequeue = new LinkedList<>();
            for(String root : dequeue){
                for(int i = 0 ; i < root.length() ; i++){
                    for(int j = 0 ; j < 26 ; j++){
                        char tempChar =(char) ('a' + j);
                        String temp = null;
                        if(i!=root.length()-1) temp = root.substring(0 , i) + tempChar + root.substring(i+1 , root.length());
                        else temp = root.substring(0 , i) + tempChar;
                        if( temp.equals(endWord) ) return changes+1;
                        if( words.contains(temp) && !inBuildTree.contains(temp) ){
                            nextDequeue.add( temp );
                            inBuildTree.add(temp);
                        }
                    }
                }
            }
            //System.out.println( nextDequeue );
            dequeue = nextDequeue;
            changes++;
        }
        return 0;
    }
}
