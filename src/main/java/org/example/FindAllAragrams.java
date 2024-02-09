package org.example;

import java.util.*;

public class FindAllAragrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character , Integer> stringMap = new HashMap<>();
        //int[] stringMap = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            if( stringMap.get( p.charAt(i) ) == null ){
                stringMap.put( p.charAt(i) , 1 );
            }else{
                int num = stringMap.get( p.charAt(i) );
                stringMap.replace( p.charAt(i) , num+1 );
            }
        }

        int can = -1;
        Map<Character , Integer> costMap = new HashMap<>();
        List<Character> orderList = new LinkedList<>();
        for( int i = 0 ; i < s.length() ; i++){

            if( stringMap.get( s.charAt(i) ) != null ){

                if( costMap.get( s.charAt(i) ) == null ){
                    costMap.put( s.charAt(i) , 1 );
                    orderList.add( s.charAt(i) );
                }else if( costMap.get( s.charAt(i) ).equals(stringMap.get( s.charAt(i) ) ) ){
                    int remove = 0;
                    int len = orderList.size();
                    System.out.println( s.charAt(i) );
                    for( int j = 0 ; j < len ; j++ ){
                        char removeChar = orderList.remove(0);
                        remove ++;
                        System.out.println( removeChar );
                        if( removeChar == s.charAt(i) ){
                            orderList.add( removeChar );
                            break;
                        }else{
                            int num = costMap.get( removeChar );
                            costMap.replace( removeChar , num - 1 );
                        }
                    }
                    can = can + remove;
                }else{
                    int num = costMap.get( s.charAt(i) );
                    costMap.replace( s.charAt(i) , num + 1 );
                    orderList.add( s.charAt(i) );
                }
                if( can == -1){
                    can = i;
                }
                if( orderList.size() == p.length() ){
                    res.add( can );
                }
            }else{
                can = -1;
                orderList.clear();
                costMap.clear();
            }
        }
        return res;
    }
}
