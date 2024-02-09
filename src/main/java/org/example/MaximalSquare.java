package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //PriorityQueue<Integer> smaller = new PriorityQueue<>( (a , b)-> b - a );//positive then return a
        int max = 0;int[][] rowContis = new int[matrix.length + 1][matrix[0].length]; // i j is represent from i - contis[i][j] raw  to i raw all is 1 in j cloum
        for( int i = 0 ; i < matrix.length ; i++ ){
            for( int j = 0 ; j < matrix[0].length ; j++ ){
                if( matrix[i][j] == '0' ) rowContis[i+1][j] = 0;
                else rowContis[i+1][j] = rowContis[i][j]+1;
            }
        }
        for( int i = 1 ; i < matrix.length+1 ; i++ ){
            PriorityQueue<Integer> smaller = new PriorityQueue<>( (a , b)-> a - b );LinkedList<Integer> queue = new LinkedList<>();
            for( int j = 0 ; j < matrix[0].length ; j++){
                if( rowContis[i][j] != 0 ){
                    smaller.add( rowContis[i][j] );queue.addLast( rowContis[i][j] );int small = smaller.peek();
                    if( queue.size() >= small ){
                        while( queue.getFirst() != small ){
                            int first = queue.removeFirst();smaller.remove( first );
                        }
                        int first = queue.removeFirst();smaller.remove( first );
                        if( first*first > max) max = first*first;
                    }
                }else smaller.clear();queue.clear();
            }
        }
        return max;
    }
}
