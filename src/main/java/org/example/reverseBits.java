package org.example;

public class reverseBits {

    //public String getBinary()
    public int reverseBits(int n) {

        int num = 0;

        if( n < 0){
            num = n*-1 - 1;
        }else{
            num = n;
        }
        int res = 0;
        for(int i = 1 ; i <=32 ; i++ ){
            res = res*2;
            int digit = 0;
            if( num%2 == 1){
                if( n > 0){
                    digit = 1;
                }
            }else{
                if( n < 0){
                    digit = 1;
                }
            }
            if( i == 1){
                res = res + -1*digit;
            }else{
                res = res + digit;
            }
            //next digit
            num = num/2;
        }
        return res;
    }
}
