package org.example;

public class MyPowerFunction {
    public double myPow(double x, int n) {
        long longN = n;
        double res = 1;
        if(n==0 || x == 1)return 1;
        else if( n < 0 ) {
            x = 1/x;
            longN = -1*longN;
        }
        while( longN != 0){
            long temp2Power = 1;//
            int mul2Time = 0;
            while( temp2Power*2 <= longN ){
                temp2Power = temp2Power*2;
                mul2Time++;
            }
            double temp = x;
            for(int i = 0 ; i < mul2Time ; i++){
                temp = temp*temp;
            }
            res = res*temp;
            longN = longN - temp2Power;
        }
        return 1;
    }
}
