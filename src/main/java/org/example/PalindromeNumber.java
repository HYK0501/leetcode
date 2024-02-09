package org.example;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if( x < 0 ){
            return false;
        }else{
            int paliNum = 0;
            int temp = x;
            while( temp !=0 ){
                int lastDigit = temp % 10;
                temp = temp/10;
                paliNum = paliNum*10;
                paliNum = paliNum + lastDigit;
            }
            if( paliNum == x){
                return true;
            }else{
                return false;
            }
        }
    }
}
