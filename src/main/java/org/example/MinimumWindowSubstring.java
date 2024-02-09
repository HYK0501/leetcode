package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        LinkedList<int[]> charAndLocationStack = new LinkedList<>();//map s,s char ( 0 ~ 25 ) and it's location
        Map<Integer , int[]> charAppearCounter = new HashMap<>(); // val[0] appear count in current s's index val[1] appear in t
        int complete = t.length(); // now have windows can contain our target? if can ten complete == 0
        int res = s.length()+1;
        int stackFirst =0, stackLast=0;
        for( int i = 0 ; i < t.length() ; i++ ) charAppearCounter.merge( t.charAt(i) - 'A' ,  new int[]{ 0 , 1 } , ( a , b ) -> { a[1]++; return a;} );
        for( int i = 0 ; i < s.length() ; i++){
            if( charAppearCounter.get( s.charAt(i) - 'A' ) != null ){
                charAndLocationStack.addLast( new int[] { (s.charAt(i) - 'A')  , i } );
                charAppearCounter.get( s.charAt(i) - 'A'  )[0]++;
                if( complete != 0 ){
                    int appear = charAppearCounter.get( s.charAt(i) - 'A' )[0];
                    int need = charAppearCounter.get( s.charAt(i) - 'A' )[1];
                    if( appear <= need) complete--;
                }
                if( complete == 0 ){
                    int stackFirstChar = charAndLocationStack.peekFirst()[0];
                    while( charAppearCounter.get( stackFirstChar )[0] > charAppearCounter.get( stackFirstChar )[1] ){
                        charAppearCounter.get( stackFirstChar )[0]--;
                        charAndLocationStack.removeFirst();
                        stackFirstChar = charAndLocationStack.peekFirst()[0];
                    }
                    int tempStackLast = charAndLocationStack.getLast()[1];
                    int tempStackFirst = charAndLocationStack.peekFirst()[1];
                    if( res > tempStackLast - tempStackFirst ) {
                        res = tempStackLast - tempStackFirst; stackFirst = tempStackFirst; stackLast = tempStackLast;
                    }
                }
            }
        }
        if( complete != 0) return "";
        return s.substring( stackFirst , stackLast+1 );
    }
}
