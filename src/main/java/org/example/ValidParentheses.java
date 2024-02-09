package org.example;

import java.util.ArrayList;

public class ValidParentheses {
    public static void main(String[] args){
       System.out.println( isValid("[{}]") );
    }
    public static boolean isValid(String s)  {
        ArrayList<Character> stack = new ArrayList<>();
        for( int i = 0 ; i < s.length() ;  i ++){
            if( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                stack.add( s.charAt(i) );
            }else{
                if( stack.isEmpty() ){
                    return false;
                }
                if( s.charAt(i) == ')'  ){
                    if(  stack.get( stack.size() -1 ) == '(' ){
                        stack.remove( stack.size() -1 );
                    }else{
                        return false;
                    }
                }else if(  s.charAt(i) == ']' ){
                    if(  stack.get( stack.size() -1 ) == '[' ){
                        stack.remove( stack.size() -1 );
                    }else{
                        return false;
                    }
                }
                else if( s.charAt(i) == '}' ){
                    if( stack.get( stack.size() -1 ) == '{'  ){
                        stack.remove( stack.size() -1 );
                    }else{
                        return false;
                    }
                }
            }
        }
        if( stack.isEmpty()){
            return true;
        }
        return false;
    }
}
