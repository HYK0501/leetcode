package org.example;

import java.util.LinkedList;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        boolean[] validLocation = new boolean[s.length()];
        LinkedList<Integer> lefts = new LinkedList<>();
        for( int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) == '(' ){
                lefts.add( i );
            }else if( s.charAt(i) == ')'){
                if( !lefts.isEmpty() ){
                    int left = lefts.removeLast();
                    validLocation[left] = true;
                    validLocation[i] = true;
                }
            }
        }
        int max = 0;
        int temp = 0;
        for( int i = 0 ; i < validLocation.length ; i++){
            if( validLocation[i] ){
                temp++;
                if( temp > max) max = temp;
            }
            else temp =0;
        }
        return max;
    }
}
