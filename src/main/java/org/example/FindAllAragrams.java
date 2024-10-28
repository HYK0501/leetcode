package org.example;

import java.util.*;

public class FindAllAragrams {
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Character> queue = new LinkedList<>();
        Map<Character , Integer> charCount = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for( int i = 0 ; i < p.length() ; i++ ) charCount.merge( p.charAt(i) , 1 , Integer::sum );
        for( int i = 0 ; i < s.length() ; i++ ){
            char nowCh = s.charAt(i);
            if( charCount.get( nowCh ) == null){
                while( !queue.isEmpty()  ){
                    char ch = queue.removeFirst();
                    charCount.put( ch , charCount.get(ch) + 1 );//restore
                }
            }else if( charCount.get( nowCh ) == 0 ){
                while( !queue.isEmpty()  ){
                    char ch = queue.removeFirst();
                    if( ch == nowCh ) break;
                    charCount.put( ch , charCount.get(ch) + 1 );//restore
                }
                queue.add( nowCh );
            }else{
                charCount.put( nowCh , charCount.get( nowCh ) - 1 );
                queue.add( nowCh );
            }
            if( queue.size() == p.length() ) res.add( i - p.length() + 1 );
        }
        return res;
    }
}
