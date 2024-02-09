package org.example;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    public int romanToInt(String s) {
        Map<Character , Integer> map = new HashMap<>();
        map.put( 'I' , 1);
        map.put( 'V' , 5 );
        map.put('X' , 10);
        map.put( 'L' , 50);
        map.put( 'C' , 100 );
        map.put( 'D' , 500 );
        map.put( 'M' , 1000);
        int res = 0;
        int finalIndex = s.length() -1 ;
        for(int i = 0 ; i < s.length() ; i++){
            int now = map.get( s.charAt(i) );
            if( i < finalIndex ){
                int next = map.get( s.charAt( i + 1) );
                if( now < next ){
                    now = -1 * now;
                }
            }
            res = res + now;
        }
        return res;


    }
}
