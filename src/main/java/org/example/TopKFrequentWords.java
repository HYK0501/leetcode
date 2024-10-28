package org.example;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        for( String str : words ) map.merge( str , 1 , Integer::sum );
        PriorityQueue< Map.Entry< String , Integer> > maxHeap = new PriorityQueue<>(
                ( e1 , e2 ) ->{
                   if( e2.getValue() != e1.getValue() ) return e2.getValue() - e1.getValue();
                   else return e1.getKey().compareTo( e2.getKey() );
                }
        );
        ArrayList<String> res = new ArrayList<>();
        for( Map.Entry< String , Integer> entry : map.entrySet() ) maxHeap.add( entry );
        for( int i = 0 ; i < k ; i++ ) res.add( maxHeap.poll().getKey() );
        return res;
    }
}
