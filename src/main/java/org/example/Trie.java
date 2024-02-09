package org.example;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node {
        public char val;
        public Map<Character , Node> neighbors;
        boolean end = false;

        public Node() {
            neighbors = new HashMap<Character , Node>();
        }
        public Node(char _val) {
            val = _val;
            neighbors = new HashMap<Character ,Trie.Node>();
        }
        public Node(char _val, HashMap<Character ,Trie.Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
        public void setEnd(){
            this.end = true;
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
        //System.out.println(root);
    }

    public void insert(String word) {
        Node now = null;
        Node temp = this.root;
        //System.out.println( this.root );

        for(int i = 0 ; i < word.length() ; i++){
            //System.out.println(i);
            now = temp.neighbors.get( word.charAt(i) );
            if( now == null ){
                now = new Node( word.charAt(i) );
                temp.neighbors.put( word.charAt(i) , now );
            }
            temp = now;
        }
        now.setEnd();
    }

    public boolean search(String word) {
        Node now = null;
        Node temp = this.root;
        for(int i = 0 ; i < word.length() ; i++){
            now = temp.neighbors.get( word.charAt(i) );
            if( now == null ){
                return false;
            }
            temp = now;
        }
        return temp.end;
    }

    public boolean startsWith(String prefix) {
        Node now = null;
        Node temp = this.root;
        for(int i = 0 ; i < prefix.length() ; i++){
            now = temp.neighbors.get( prefix.charAt(i) );
            if( now == null ){
                return false;
            }
            temp = now;
        }
        return true;
    }
}