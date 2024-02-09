package org.example;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = -1;
        LinkedList<Integer> res = new LinkedList<>();
        for( int i = 0 ; i < arr.length-1 ; i++){
            if( arr[i] < x && arr[i+1]>x ){
                index = i;
                break;
            }
        }
        if( index == -1 ){
            if( x < arr[0] ) index = 0;
            else index = arr.length-1;
        }
        int leftIndex = index;
        int rightIndex = index+1;
        while( res.size() != k){
            int left;int right;
            if( leftIndex >= 0 && rightIndex < arr.length){
                left = arr[leftIndex];
                right=arr[rightIndex];
                if( Math.abs(left - x) <= Math.abs( right - x ) ){
                    res.addFirst( left );
                    leftIndex--;
                }else{
                    right=arr[rightIndex];
                    res.add(right);
                    rightIndex++;
                }
            }else if( leftIndex >=0 ){
                left = arr[leftIndex];
                res.addFirst( left );
                leftIndex--;
            }else if( rightIndex < arr.length ){
                right=arr[rightIndex];
                res.add(right);
                rightIndex++;
            }else break;
        }
        return res;
    }
}
