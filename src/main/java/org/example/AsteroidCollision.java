package org.example;

import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for( int asteroid : asteroids ){
            if( stack.isEmpty() ) stack.add( asteroid );
            if( asteroid < 0 && stack.getLast() > 0 ){
                boolean addThis = true;
                while( asteroid < 0 && stack.getLast() > 0 ){
                    if( stack.getLast() > asteroid*-1 ){
                        addThis = false;
                        break;
                    }else stack.removeLast();
                }
                if( addThis ) stack.add(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = 0 ; i < res.length ; i++) res[i] = stack.removeFirst();
        return res;
    }
}
