package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] decodeNumbers = new int[s.length()+1];
        decodeNumbers[0] = 1;
        for(int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) != '0' && decodeNumbers[i]!=0 ) decodeNumbers[i+1] =  decodeNumbers[i+1] + decodeNumbers[i];
            if( i != 0 ){
                if( s.charAt(i-1) != '0'){
                    int twoIndex = Integer.parseInt( s.substring( i-1 , i+1 ) );
                    if( twoIndex < 27 && decodeNumbers[i-1]!=0 ) decodeNumbers[i+1] = decodeNumbers[i+1] + decodeNumbers[i-1];
                }
            }
        }
        return decodeNumbers[s.length()];
    }
}
