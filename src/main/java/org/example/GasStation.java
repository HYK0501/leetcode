package org.example;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int acc = 0;
        int totalAcc = 0;
        int[] mins = new int[gas.length];
        mins[0] = gas[0] - cost[0];
        for( int i = 0 ; i < gas.length ; i++ ){
            acc = acc + gas[i] - cost[i];
            totalAcc = totalAcc + gas[i] - cost[i];
            if( i>0 ) mins[i] = Math.min( mins[i-1] , totalAcc );
            if( acc < 0 ){
                acc = 0;
                start = i+1;
            }

        }
        if( start == gas.length ) return -1;
        if(start == 0) return 0;
        else if( acc >= -mins[ start -1 ] ) return start;
        return -1;
    }
}
