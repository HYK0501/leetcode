package org.example;

import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> operations = new LinkedList<>();
        LinkedList<String> subStrings = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) == '[' ){
                int number = 0;
                int ten = 1;
                for(int j = 1 ; j < 4 ; j++){
                    if( i - j < 0) continue;
                    int digit = s.charAt( i - j ) - '0';
                    if( digit >= 0 && digit < 10 ) number = number + digit*ten;
                    else break;
                    ten = ten*10;
                }
                operations.addFirst( number );
                subStrings.addFirst( sb.toString() );
                sb = new StringBuilder();
            }else if( s.charAt(i) == ']' ){
                int repeat = operations.removeFirst();
                String str = sb.toString();
                for( int j = 1 ; j < repeat ; j++) sb.append(str);
                String preSubString = subStrings.removeFirst();
                sb = new StringBuilder( preSubString + sb.toString() );
                if( subStrings.isEmpty() ){
                    res.append( sb.toString() );
                    sb = new StringBuilder();
                }
            }
            else if( s.charAt(i) >= 97 &&  s.charAt(i) <= 122 ){
                if( operations.isEmpty() ) res.append( s.charAt(i) );
                else sb.append( s.charAt(i) );
            }
        }
        return res.toString();
    }
}
