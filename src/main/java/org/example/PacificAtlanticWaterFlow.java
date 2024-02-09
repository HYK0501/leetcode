package org.example;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public void flowToUp( int i , int j , int[][] heights ,boolean[][] flow){
        if( flow[i][j] ){
            return;
        }
        flow[i][j] = true;
        int[][] direct = { { 1,0} , {-1 , 0 } , { 0 , -1} , { 0 , 1}};
        for( int index = 0 ; index < 4 ; index++){
            int newI = i + direct[index][0];
            int newJ = j + direct[index][1];
            if( newJ > -1 && newI > -1 && newI < heights.length && newJ < heights[0].length){
                if( heights[i][j] <= heights[newI][newJ] ){
                    flowToUp( newI , newJ , heights , flow);
                }
            }
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacificOcean = new boolean[ heights.length ][ heights[0].length ];
        boolean[][] atlantiOceans = new boolean[ heights.length ][ heights[0].length ];
        for( int i = 0 ; i < heights.length ; i++ ){
            flowToUp( i , 0 , heights , pacificOcean);
            flowToUp( i , heights[0].length - 1 , heights , atlantiOceans);
        }
        for( int i = 0 ; i < heights[0].length ; i++ ){
            flowToUp( 0 , i , heights , pacificOcean);
            flowToUp( heights.length - 1  , i , heights , atlantiOceans);
        }
        for( int i = 0 ; i < heights.length ; i++ ){
            for( int j = 0 ; j < heights[0].length ; j++ ){
                if( atlantiOceans[i][j] &&  pacificOcean[i][j]){
                    List<Integer> cord = new ArrayList<>();
                    cord.add( i );
                    cord.add(j);
                    res.add(cord);
                }
            }
        }
        return res;
    }
}
