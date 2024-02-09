package org.example;

public class hammingWeight {

    public int getBits(int n){
        int sum = 0;
        int digit = 2;
        while( n!=0 ){
            if( n%digit !=0 ){
                sum++;
                n = n - 1;
            }
            n = n/2;
            //System.out.println( n );
        }
        return sum;
    }

    public int hammingWeight(int n) {
        //System.out.println( n );
        if( n == -1){
            return 32;
        }else if( n== -2147483648 ){
            return 1;
        }
        else{
            int sum = 0;
            if( n < 0){
                sum = getBits( (n*-1) -1 );
                return 32 - sum;
            }else{
                sum = getBits( n );
                return sum;
            }
        }
    }
}
