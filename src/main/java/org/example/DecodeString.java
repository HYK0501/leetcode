package org.example;

import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        int duplicate = -1;
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < s.length() ; i++ ){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                if( duplicate == -1 ){
                    strStack.add( sb.toString() );
                    sb.delete( 0 , sb.length() );
                    duplicate = s.charAt(i) - '0';
                }else{
                    duplicate = duplicate*10 + s.charAt(i) - '0';
                }
            }else if( s.charAt(i) == '[' ){
                //go to next level
                numStack.add( duplicate );
                duplicate = -1;
            }else if( s.charAt(i) == ']' ){
                //return pre level
                String left = strStack.removeLast();
                String right = sb.toString();
                int num = numStack.removeLast();
                StringBuilder merge = new StringBuilder();
                merge.append( left );
                for( int j = 0 ; j < num ; j++) merge.append( right );
                sb = merge;
            }else{
                sb.append( s.charAt(i) );
            }
        }
        return strStack.isEmpty() ? sb.toString() : strStack.removeLast() + sb.toString();
    }
}
