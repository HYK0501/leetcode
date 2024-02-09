package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumHeightTrees {
    //prevent n^2 condition
    public boolean check(Map<Integer , Integer> map){
        for( Integer value : map.values()){
            if( value > 1 ){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if( edges.length == 0){
            ArrayList<Integer> points = new ArrayList<>();
            points.add(0);
            return points;
        }
        Map<Integer , Integer> degrees = new HashMap<>();
        Map<Integer , Set<int[]>> relatedEdge = new HashMap<>();
        Set<int[]> edgesSet = new HashSet<>();
        for(int i = 0 ; i < edges.length ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if( degrees.get( edges[i][j] ) == null  ){
                    degrees.put( edges[i][j] , 1);
                    relatedEdge.put( edges[i][j] , new HashSet<>());
                    relatedEdge.get( edges[i][j] ).add( edges[i] );
                }else{
                    degrees.replace( edges[i][j] ,  degrees.get( edges[i][j] ) + 1 );
                    relatedEdge.get( edges[i][j] ).add( edges[i] );
                }
                //edgesSet.add( edges[i] );
            }
        }

        //Set<Integer> remove = new HashSet<>();
        while( !check( degrees ) ){
            Set<Integer> remove = new HashSet<>();
            for( Integer point : degrees.keySet() ){
                if( degrees.get(point) == 1){
                    remove.add( point );
                }
            }
            for( Integer point :  remove ){
                for( int[] removeEdge : relatedEdge.get( point ) ){
                    for( int i = 0 ; i < 2 ; i++ ){
                        if( removeEdge[i] != point ){
                            relatedEdge.get( removeEdge[i] ).remove( removeEdge );
                            degrees.replace(  removeEdge[i]  ,  degrees.get(  removeEdge[i]  ) -1 );
                        }
                    }
                }
                degrees.remove( point );
                relatedEdge.remove( point );
            }
        }
        return degrees.keySet().stream().collect(Collectors.toList());
    }
}
