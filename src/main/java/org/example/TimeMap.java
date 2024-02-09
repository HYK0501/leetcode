package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class TimeMap {
    //sol sol
    HashMap<String , HashMap<Integer , String>> storeMap;
    HashMap<String , List<Integer> > timeRecords;
    public TimeMap() {
        storeMap = new HashMap<>();
        timeRecords = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if( storeMap.get(key) != null){
            storeMap.get(key).put( timestamp , value );
            timeRecords.get(key).add( timestamp );
        }else{
            ArrayList<Integer> times = new ArrayList<>();
            HashMap<Integer , String> values = new HashMap<>();
            values.put( timestamp , value );
            storeMap.put( key , values);
            times.add( timestamp );
            timeRecords.put( key , times);
        }
    }

    public String get(String key, int timestamp) {
        HashMap<Integer , String> values = storeMap.get( key );
        if( values == null){
            return "";
        }else{
            List<Integer> times = timeRecords.get( key );
            int low = 0;
            int upper = times.size() - 1;
            int cand = -1;
            while( low <= upper ){
                int mid = ( low + upper )/2;
                if( times.get(mid) == timestamp ){
                    return values.get( timestamp );
                }else if( times.get(mid) > timestamp ){
                    upper = mid - 1;
                }else if( times.get( mid ) < timestamp ){
                    cand = times.get(mid);
                    low = mid + 1;
                }
            }
            if( cand != -1){
                return values.get( cand );
            }
            return "";
        }
    }
}