package org.example;

import java.util.*;

public class WordDictionary {
    public class ChNode{
        ChNode[] nextNodes;
        Character ch;
        boolean end = false;

        public ChNode(char ch){
            this.ch = ch;
            nextNodes = new ChNode[26];
        }

        public void addNext( ChNode nextNode ){
            nextNodes[nextNode.ch - 'a'] = nextNode;
        }
    }

    ChNode[] nodeMap;

    public WordDictionary() {
        nodeMap = new ChNode[26];
    }

    public void addWord(String word) {
        int index = 0;
        ChNode[] map = nodeMap;
        ChNode nextNode =  nodeMap[word.charAt(index) - 'a'];
        while( nextNode != null ){
            index++;
            map = nextNode.nextNodes;
            if( index == word.length() ) break;
            nextNode = nextNode.nextNodes[word.charAt(index) - 'a'];
        }
        ChNode newNode = nextNode;
        for( int i = index ; i < word.length() ; i++ ){
            newNode = new ChNode( word.charAt(i) );
            map[newNode.ch - 'a'] = newNode;
            map = newNode.nextNodes;
        }
        newNode.end = true;
    }

    public boolean search( ChNode[] nodeMap , String str , int index ){
        if( str.charAt(index) != '.' ){
            ChNode nextNode = nodeMap[str.charAt(index) - 'a'];
            if( nextNode == null ){
                return false;
            }else{
                if( index == str.length()-1 ) {
                    if( nextNode.end ) return true;
                    else return false;
                }
                return search( nextNode.nextNodes , str , index+1 );
            }
        }else{
            ChNode nextNode;
            for( int i = 0 ; i < 26 ; i++){
                nextNode = nodeMap[i];
                if( nextNode != null) {
                    if (index == str.length() - 1) {
                        if (nextNode.end) return true;
                    } else if (search(nextNode.nextNodes, str, index + 1)) return true;
                }
            }
            return false;
        }
    }

    public boolean search(String word) {
        return search( nodeMap , word , 0 );
    }
}
