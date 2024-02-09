package org.example;

import java.util.*;

public class LRUCache {
    ArrayList<Integer> order;
    Map<Integer , Integer> map;

    Map<Integer , Integer> opsMap;
    int capacity;

    int ops;

    int lastLacation = 0;

    //Map<Integer , Integer> keyLocation


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.order = new ArrayList<>();
        this.map = new HashMap<>();
        this.opsMap = new HashMap<>();
    }

    public int get(int key) {
        if( map.keySet().contains( key ) ){
            ops++;
            opsMap.replace( key , ops );
            order.add( key );
            return map.get(key);
        }else{
            //order.addLast( key );
            return -1;
        }
    }

    public void put(int key, int value) {
        ops++;
        if( map.keySet().size() == capacity && !map.keySet().contains( key )){
            for( int i = lastLacation  ; i < order.size() ; i++ ){
                if( opsMap.get( order.get(i) ) != null){
                    if( i + 1 == opsMap.get( order.get(i) )){
                        lastLacation = i;
                        break;
                    }
                }
            }
            opsMap.remove( order.get( lastLacation ) );
            map.remove( order.get( lastLacation ) );
            lastLacation++;
        }
        opsMap.put(key , ops);
        order.add( key );
        map.put( key , value );
    }
}
