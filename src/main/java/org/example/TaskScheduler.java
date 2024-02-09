package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    //you need see this solution!! https://leetcode.com/problems/task-scheduler/solutions/104500/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/
    public int leastInterval(char[] tasks, int n) {
        int[] appearRate = new int[26];
        int max = 0;
        int maxNumber = 0;
        for( int i = 0 ; i < tasks.length ; i++ ){
            appearRate[tasks[i] - 'A'] = appearRate[tasks[i] - 'A'] + 1;
            if( appearRate[tasks[i] - 'A'] > max){
                max = appearRate[tasks[i] - 'A'];
                maxNumber = 1;
            }else if( appearRate[tasks[i] - 'A'] == max){
                maxNumber++;
            }
        }

        int part = max - 1;
        int emptySlot = Math.max( 0  , part * ( n - maxNumber + 1 ) - ( tasks.length - maxNumber*max ) );
        System.out.println( tasks.length );
        return tasks.length + emptySlot;

    }
}
