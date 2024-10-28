package org.example;

import java.util.*;

public class BGDCPCounter {
    
    public static void reInset(int[] node, PriorityQueue<int[]> minHeap){
        minHeap.remove(node);
        node[1] = node[1]--;
        minHeap.add(node);
    }

    public static int counter(int[][] input){

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[][] nodes = new int[input.length][2];
        HashSet<Integer> points = new HashSet<>();
        //init
        for(int i = 0; i < input.length ; i++){
            nodes[i][0] = i;
            for(int j = 0; j < input[0].length ; j++){
                if(input[i][j]==1) nodes[i][1]++;
            }
            minHeap.add(nodes[i]);
        }
        //find point v , u
        while(!minHeap.isEmpty()){
            int[] minNodePair = minHeap.poll();
            int v = minNodePair[0];
            points.add(v);
            int u = -1;
            for(int i = 0 ; i < input.length ; i++){
                if( input[v][i]!=0 && !points.contains(i) ) {
                    u=i;
                    points.add(u);
                    minHeap.remove(nodes[u]);
                    break;
                }
            }
            if(u==-1) break;
            else{
                for(int i = 0 ; i < input.length ; i++){
                    if(input[v][i]!=0 && i!=u && !points.contains(i)) reInset(nodes[i],minHeap);
                    if(input[u][i]!=0 && i!=v && !points.contains(i)) reInset(nodes[i],minHeap);
                }
            }
        }
        return points.size()/2;
    }

    public static void main(String[] args){
        int[][] input = { {0,1,0,1},{1,0,1,0},{0,1,0,1},{1,0,1,0} };
        System.out.println( counter(input) );
    }

}
