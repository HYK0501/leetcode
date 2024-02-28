package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class coinChange {

    public int coinChange(int[] coins, int amount) {
        int[] res = new int[ amount + 1];
        Arrays.sort( coins );
        res[0] = 0;
        for( int i = 1 ; i < amount + 1 ; i++ ) res[i] = -1;
        for( int i = 0 ; i < coins.length ; i++){
            if( coins[i] <= amount) res[ coins[i] ] = 1;
            else break;
        }
        for( int i = 0 ; i < amount + 1 ; i++ ){
            for( int j = 0 ; j < coins.length ; j++ ){
                if( coins[j] <= i){
                    if( i - coins[j] > 0 ){
                        if( res[i] > 0 &&  res[ i - coins[j] ] > 0) res[i] = Math.min( res[i] , res[ i - coins[j] ] + 1 );
                        else if( res[ i - coins[j] ] > 0 ) res[i] = res[ i - coins[j] ] + 1;
                    }
                }else break;
            }
        }
        return res[ amount ];
    }
}
