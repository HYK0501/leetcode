package org.example;

public class myAtoi {
    public int myAtoi(String s) {
        if( s.isEmpty() ){
            return 0;
        }
        int res = 0;
        int ignore = 0;
        for(int i = 0  ; i < s.length() ; i++){
            if( s.charAt(i) == ' ' ){
                ignore++;
            }else{
                break;
            }
        }
        s = s.substring( ignore );
        boolean negative = false;

        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }else if( s.charAt(0) == '+'){
            s = s.substring( 1 );
        }

        int nonDigit = 0;
        for(int i = 0  ; i < s.length() ; i++){
            int digit = s.charAt(i) - '0';
            if( ! ( digit < 10 && digit > -1) ){
                nonDigit = i;
                break;
            }
        }
        s = s.substring( 0 , nonDigit );
        int ignoreZero = 0;
        for(int i = 0  ; i < s.length() ; i++){
            if( s.charAt(i) == '0' ){
                ignoreZero++;
            }else{
                break;
            }
        }
        s = s.substring( ignoreZero );

        if( negative ){
           String min = Integer.toString( Integer.MIN_VALUE );
           int len = min.length() - 1;
           if( len < s.length()){
               return Integer.MIN_VALUE;
           }else if(len == s.length() ){
               for( int i = s.length()-1 ; i > -1 ; i--){
                   if( s.charAt(i) > min.charAt(i) ){
                       return Integer.MIN_VALUE;
                   }
               }
           }
        }else{
            String max = Integer.toString( Integer.MAX_VALUE );
            int len = max.length();
            if( len < s.length()){
                return Integer.MAX_VALUE;
            }else if(len == s.length() ){
                for( int i = s.length()-1 ; i > -1 ; i--){
                    if( s.charAt(i) > max.charAt(i) ){
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }

        for(int i = 0 ; i < s.length() ; i++){
            res = res*10;
            int digit = s.charAt(i) - '0';
            res = res + digit;
        }
        return res;
    }
}
