package org.example;

import java.util.HashMap;
import java.util.Map;

public class RandomPickwithWeight {
    int[] map;
    int sum;
    public RandomPickwithWeight(int[] w) {
        this.sum = 0;
        map = new int[w.length];
        for(int i = 0 ; i < w.length ; i ++){
            map[i] = this.sum;
            this.sum = this.sum + w[i];
        }
    }

    public int pickIndex() {
        int i = (int)(  Math.random() * this.sum );
        int low = 0; int up = map.length -1;
        while( low > up) {
            int mid = ( low + up)/2;
            if( mid + 1< map.length ){
                if( map[mid] == i ||  (map[mid]-i)*(map[mid+1]-i) < 0 ) return mid;
                else if( map[mid] < i ) up = mid - 1;
                else low = mid + 1;
            }else return mid;
        }
        return 0;
    }
}
