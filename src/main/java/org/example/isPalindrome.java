package org.example;

import java.util.ArrayList;

public class isPalindrome {
    public static void main(String[] args){
        System.out.println( isPalindrome(",'6``c4i,::,i4ckk6',") );
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while( start < end ){
            if( !Character.isLetterOrDigit( s.charAt(start) ) ) start++;
            else if( !Character.isLetterOrDigit( s.charAt(end) ) ) end--;
            else{
                if( Character.toLowerCase( s.charAt(start) ) !=  Character.toLowerCase( s.charAt(end) ) ) return false;
                else{
                    start++;
                    end--;
                }
            }
        }
        if( end < 0 ) return false;
        return true;
    }
}
