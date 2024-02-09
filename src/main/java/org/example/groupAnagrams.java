package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Map<Character , Integer>, ArrayList<String>> anagramMap = new HashMap<>();
        for(String str : strs){
            Map<Character , Integer> map = new HashMap<>();
            for( int i = 0 ; i < str.length() ; i++ ){
                char ch = str.charAt(i);
                if( map.get( ch ) != null){
                    map.put( ch , map.get(ch) + 1 );
                }else{
                    map.put( ch , 1 );
                }
            }
            if( anagramMap.get( map ) == null ){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                anagramMap.put( map , list );
            }else{
                anagramMap.get(map).add(str);
            }
        }
        for( ArrayList<String> list : anagramMap.values() ){
            res.add( list );
        }
        return res;
    }
}
