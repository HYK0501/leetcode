package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class myAtoi {
    public int myAtoi(String s) {
        int index = 0;
        boolean negative = false;
        try{
            while( s.charAt(index) == ' ' ) index++;
            while( s.charAt(index) == '+' || s.charAt(index) == '-' ){
                if( s.charAt(index) == '-' ) negative = true;
                index++;
                break;
            }
            while( s.charAt(index) == '0' ) index++;
            int res = 0;
            for( int i = index ; i < s.length() ; i++ ){
                int digit = s.charAt(i) - '0';
                if( digit < 0 || digit > 9 ) break;
                else if( ( res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && digit >= 7 ) && !negative ) return Integer.MAX_VALUE;
                else if( ( -res < Integer.MIN_VALUE/10 ||  -res == Integer.MIN_VALUE/10 && digit >= 8 ) && negative  ) return Integer.MIN_VALUE;
                res = res*10 + ( digit );
            }
            if( negative ) res = res*-1;
            return res;
        }catch( StringIndexOutOfBoundsException e){
            return 0;
        }
    }
}
