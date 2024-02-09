package org.example;

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while( x != 0){
            long digit = x%10;
            res = res + digit;
            if( res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            res = res*10;
            x = x/10;
        }
        return (int)res;
    }
}
