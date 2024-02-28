package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        LinkedList<Character> queue = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++){
            while( set.contains( s.charAt(i) ) ) set.remove( queue.removeFirst()  );
            set.add( s.charAt(i) );
            queue.add( s.charAt(i) );
            if( queue.size() > max ) max = queue.size();
        }
        return max;
    }
}
