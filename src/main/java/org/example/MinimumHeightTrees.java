package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumHeightTrees {
    //prevent n^2 condition
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        Map<Integer , List<Integer>> graph = new HashMap<>();
        for( int[] edge : edges ){
            degree[edge[0]]++;
            degree[edge[1]]++;
            if( graph.get( edge[0] ) == null ) graph.put( edge[0] , new ArrayList<>() );
            if( graph.get( edge[1] ) == null ) graph.put( edge[1] , new ArrayList<>() );
            graph.get( edge[0] ).add( edge[1] );
            graph.get( edge[1] ).add( edge[0] );
        }
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ){
            if( degree[i] <= 1 ) list.add( i );
        }
        while( true ){
            ArrayList<Integer> next = new ArrayList<>();
            for( Integer num : list){
                if( graph.get( num ) == null ) continue;
                for( Integer related : graph.get( num ) ){
                    if( degree[related] > 0 ){
                        degree[related] --;
                        degree[ num ]--;
                        if( degree[related] == 1 ) next.add( related );
                    }
                }
            }
            if( next.isEmpty()) break;
            list = next;
        }
        return list;
    }
}
