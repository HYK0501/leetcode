package org.example;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public class TNode{
        public TNode[] nextNodes;
        public boolean end = false;

        public TNode() {
            nextNodes = new TNode[26];
        }
    }

    TNode[] firsts;
    public Trie() {
        firsts = new TNode[26];
    }

    public void insert(String word) {
        TNode[] temp = firsts;
        TNode node = null;
        for( int i = 0 ; i < word.length() ; i++){
            node = temp[word.charAt(i) - 'a'];
            if( node == null ){
                node = new TNode();
                temp[word.charAt(i) - 'a'] = node;
            }
            temp = node.nextNodes;
        }
        node.end = true;
    }

    public boolean search(String word) {
        TNode[] temp = firsts;
        TNode node = null;
        for( int i = 0 ; i < word.length() ; i++){
            node = temp[word.charAt(i) - 'a'];
            if( node == null ) return false;
            temp = node.nextNodes;
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TNode[] temp = firsts;
        TNode node = null;
        for( int i = 0 ; i < prefix.length() ; i++){
            node = temp[prefix.charAt(i) - 'a'];
            if( node == null ) return false;
            temp = node.nextNodes;
        }
        return true;
    }
}