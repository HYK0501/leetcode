package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length()) return false;
        int[] chs = new int[26];
        int[] cht = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            chs[ (int) s.charAt(i) - 'a' ]++;
            cht[ (int) t.charAt(i) - 'a' ]++;
        }
        for( int i = 0 ; i < 26 ; i++ ) if( chs[i] != cht[i] ) return false;
        return true;
    }

}
