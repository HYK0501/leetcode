package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class coinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if( amount == 0){
            return 0;
        }
        else if(amount % coins[coins.length-1] == 0){
            return amount / coins[coins.length-1];
        }else{
            int[] res = new int[amount];
            for( int i = 0 ; i < amount ; i++){
                res[i] = -1;
                for( int j = 0 ; j < coins.length ; j++){
                    if( i + 1 == coins[j]){
                        res[i] = 1;
                    }else if( i+1 < coins[j] ){
                        break;
                    }else{
                        int temp = 1 + res[ i - coins[j] ];
                        if( temp != 0 ){
                            if( res[i] == -1){
                                res[i] = temp;
                            }
                            //res[i] = temp;
                            else if( res[i] > temp  ){
                                res[i] = temp;
                            }
                        }
                    }
                }
            }
            return res[amount-1];
        }
    }
}
