package org.example;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<Integer , List<String> > frenqcyToWord = new HashMap<>();
        Map<String , Integer> wordSfrequency = new HashMap<>();
        frenqcyToWord.put(1 , new ArrayList<>());
        for( String word : words ){
            Integer frequency = wordSfrequency.get( word );
            if( frequency == null ){
                wordSfrequency.put( word , 1 );
                frenqcyToWord.get(1).add( word );
            }else{
                frenqcyToWord.get( frequency ).remove( word );
                wordSfrequency.put( word , frequency + 1 );
                List<String> list = frenqcyToWord.get( frequency + 1 );
                if( list == null ){
                    list = new ArrayList<>();
                    frenqcyToWord.put( frequency + 1 , list );
                }
                list.add( word );
            }
        }
        List<String> res = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>( frenqcyToWord.keySet() );
        Collections.sort( sortedList  , Collections.reverseOrder());
        for( Integer num : sortedList ){
            Collections.sort( frenqcyToWord.get(num) );
            for( String word : frenqcyToWord.get(num) ){
                res.add( word );
                if( res.size() == k ){
                    return res;
                }
            }
        }
        return res;
    }
}
