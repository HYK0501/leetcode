package org.example;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] mins = new int[gas.length]; //from 0 to i min
        int[] accs = new int[gas.length];int min = 0; int mostMin = 0;int acc = 0;
        for( int i = 0 ; i < gas.length ; i++){
            min = min + gas[i] - cost[i];
            acc = acc + gas[ gas.length - 1 - i ] - cost[ gas.length - 1 -i ];
            accs[ gas.length - 1 - i ] = acc;
            if( mostMin > min ){
                mostMin = min;
            }
            mins[i] = mostMin;
        }
        if( mins[ gas.length - 1 ] >= 0 ){
            return 0;
        }else{
            int res = -1;
            for( int i = 1 ; i < gas.length ; i++){
                if( -mins[i - 1] <= accs[i] && gas[i] >= cost[i] ){
                    res = i;
                }
            }
            return res;
        }
    }
}
