package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void swap( int[] data , int i , int j ){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public static void set( int x ){x=2; }
    public static void main(String[] args){
        /*
        int[] data = { 58, 66, 15, 8, 37, 44, 91, 32, 39, 57, 85, 100, 65, 26, 19, 49 };
        for( int i = 0 ; i < data.length ; i++ ){
            for( int j = 0 ; j < data.length - i ; j++ ){
                if( j!= data.length-1 ) {
                    if (data[j] > data[j + 1]) {
                        swap(data, j, j + 1);
                    }
                }
            }
        }
        for( int i = 0 ; i < data.length ; i++  ) System.out.print( data[i] + " " );
         */
        int i = 0;
        set( i );
        System.out.print( i );
    }
}