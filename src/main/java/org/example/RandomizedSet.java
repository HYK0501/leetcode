package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {
    Map<Integer , Integer> indexToVal;
    Map<Integer , Integer> valToIndex;

    int maxIndex;

    public RandomizedSet() {
        maxIndex = 0;
        indexToVal = new HashMap<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if( valToIndex.get(val)!=null ) return false;
        else{
            maxIndex++;
            valToIndex.put( val , maxIndex);
            indexToVal.put( maxIndex , val);
            return true;
        }
    }

    public boolean remove(int val) {
        if( valToIndex.get(val) == null ) return false;
        else {
            int delIndex = valToIndex.get(val);
            int lastVal = indexToVal.get( maxIndex );
            valToIndex.remove(val);
            indexToVal.remove( maxIndex );
            if( lastVal != val ){
                valToIndex.put( lastVal , delIndex );
                indexToVal.put( delIndex , lastVal );
            }
            maxIndex--;
            return true;
        }
    }

    public int getRandom() {
        int randomIndex = (int) ( Math.random()* ( maxIndex ) ) +1;
        return indexToVal.get( randomIndex );
    }
}
