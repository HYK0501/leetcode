package org.example;

import java.util.LinkedList;

public class LongestPalindromeSubString {
    public int getPalindromeInMiddle( int middleLen , int left , int right ,  String s){
        if( left < 0 || right >= s.length() ){
            return middleLen;
        }
        while( s.charAt(left) == s.charAt(right) ){
            middleLen = middleLen + 2;
            left --;
            right++;
            if( left < 0 || right >= s.length() ){
                break;
            }
        }
        return  middleLen;
    }
    public String longestPalindrome(String s) {
        int max = 1;
        int maxMiddle = 0;
        for( int i = 0 ; i < s.length() ; i++){
            int left = i-1;
            int right = i+1;
            if( i > 0 && i + 1 < s.length()){
                int temp;
                if( s.charAt( i - 1 ) == s.charAt( i + 1 )){
                    temp = getPalindromeInMiddle( 1 , left , right , s);
                    if( temp > max){
                        maxMiddle = i;
                        max = temp;
                    }
                }
            }
            if( i + 1 < s.length() ){
                if( s.charAt( i ) == s.charAt( i + 1 ) ){
                    int temp;
                    right = right + 1;
                    temp = getPalindromeInMiddle( 2 , left , right  , s);
                    if( temp > max){
                        maxMiddle = i;
                        max = temp;
                    }
                }
            }
        }

        if( max % 2 == 1){
            int len = (max-1)/2;
            return s.substring( maxMiddle - len , maxMiddle + len +1 );
        }else{
            int len = max/2;
            return s.substring( maxMiddle - len + 1 , maxMiddle + len + 1);
        }
    }
}
