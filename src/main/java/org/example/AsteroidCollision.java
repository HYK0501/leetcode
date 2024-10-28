package org.example;

import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0 ; i < asteroids.length ; i++ ){
            boolean broken = false;
            while( !stack.isEmpty() ){
                if( stack.peekLast() < 0 || stack.peekLast()*asteroids[i] >= 0 ) break;
                else if(  Math.abs( stack.peekLast() ) < Math.abs( asteroids[i] ) ) stack.removeLast();
                else {
                    if(  Math.abs( stack.peekLast() ) == Math.abs( asteroids[i] ) ) stack.removeLast();
                    broken = true;
                    break;
                }
            }
            if( !broken ) stack.add( asteroids[i] );
        }
        int[] res = new int[stack.size()];
        for(int i = 0 ; i < res.length ; i++) res[i] = stack.removeFirst();
        return res;
    }
}
