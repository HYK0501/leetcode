package org.example;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 1;
        int start = 0;
        for( int i = 0 ; i < 26 ; i++){
            int temp = 0; int fill = k;
            char ch = (char) ('A' + i);
            Queue<Integer> fliiLocations = new LinkedList<>();
            for( int j = 0 ; j < s.length() ; j++){
                if( s.charAt(j) == ch ){
                    temp++;
                }else if(k!=0 ){
                    if( fill > 0 ){
                        fill--;
                        temp++;
                    }else{
                        int firstFill = fliiLocations.poll();
                        start = firstFill + 1;
                        temp = j - start + 1;
                    }
                    fliiLocations.add(j);
                }else{
                    temp = 0;
                }
                if( temp > max) max = temp;
            }
        }
        return max;
    }
}
