package org.example;

import java.util.*;

public class WordDictionary {
    CNode[] root;
    public class CNode {
        CNode[] nexts;
        boolean end;

        CNode(){
            nexts = new CNode[26];
            end = false;
        }
    }
    public WordDictionary() {
        root = new CNode[26];
    }

    public void addWord(String word) {
        CNode[] nowLevel = root;
        CNode node = null;
        for( int i = 0 ; i < word.length() ; i++ ){
            if( nowLevel[ word.charAt(i) - 'a' ] == null ) nowLevel[ word.charAt(i) - 'a' ] = new CNode();
            node = nowLevel[ word.charAt(i) - 'a' ];
            nowLevel = node.nexts;
        }
        node.end = true;
    }

    public boolean search( String word , int index , CNode[] level ){
        if( index == word.length()-1 ){
            if( word.charAt(index) == '.' ){
                for( int i = 0 ; i < 26 ; i++ ) if( level[i] != null ) if( level[i].end ) return true;
                return false;
            }else{
                return level[ word.charAt(index) - 'a' ] == null ? false : level[ word.charAt(index) - 'a' ].end;
            }
        }else{
            if( word.charAt(index) == '.' ){
                for( int i = 0 ; i < 26 ; i++ )
                    if( level[i] != null ){
                        if( search( word , index+1 , level[i].nexts ) ) return true;
                }
                return false;
            }else{
                return level[ word.charAt(index) - 'a' ] == null ? false : search( word , index+1 , level[ word.charAt(index) - 'a' ].nexts );
            }
        }
    }

    public boolean search(String word) {
        return search( word , 0 , root );
    }
}
