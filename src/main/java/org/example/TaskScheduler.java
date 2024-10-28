package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    //you need see this solution!! https://leetcode.com/problems/task-scheduler/solutions/104500/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/
    public int leastInterval(char[] tasks, int n) {
        int[] appears = new int[26];int max = 0;int maxIndex = 0;
        for( int i = 0 ; i < tasks.length ; i++ ) {
            appears[ tasks[i] - 'A' ] = appears[ tasks[i] - 'A' ] + 1;
            if( appears[ tasks[i] - 'A' ] > max ) {
                maxIndex = tasks[i] - 'A';
                max = appears[ tasks[i] - 'A' ];
            }
        }
        int res = 1 + ( n + 1 )*( appears[ maxIndex ] - 1 );
        int slots = n * ( appears[ maxIndex ] - 1 );
        int slot = appears[ maxIndex ] - 1;
        appears[ maxIndex ] = 0;
        for(int i = 0 ; i < 26 ; i++ ){
            if( slots > 0 ){
                int origin = appears[i];
                appears[i] = Math.max( 0 , appears[i] - Math.min( slots , slot) );
                slots = slots - origin + appears[i];
            }
            res = res + appears[i];
        }
        return res;
    }
}
