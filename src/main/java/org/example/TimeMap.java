package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TimeMap {
    Map<String , String> valueMap;
    Map<String ,ArrayList<Integer>> timeStamps;
    public TimeMap() {
        valueMap = new HashMap<>();
        timeStamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valueMap.put( key + timestamp , value );
        if( timeStamps.get(key) == null) timeStamps.put( key , new ArrayList<>() );
        timeStamps.get( key ).add( timestamp );
    }

    public String get(String key, int timestamp) {
        ArrayList<Integer> times = timeStamps.get(key);
        if( times == null ) return "";
        if( timestamp < times.get(0) ) return "";
        int lo = 0;
        int hi = times.size() - 1;
        while( lo < hi ){
            // auto up 1
            int mid = lo + ( hi - lo + 1)/2;
            if( timestamp > times.get( mid ) ) lo = mid;
            else if( timestamp == times.get( mid ) ){
                lo = mid;
                break;
            }else{
                // down 1
                hi = mid - 1;
            }
        }
        return valueMap.get( key + times.get(lo));
    }
}