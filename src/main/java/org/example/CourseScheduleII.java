package org.example;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] degree = new int[ numCourses ];
       int[] res = new int[ numCourses ];
       Map<Integer , List<Integer> > nexts = new HashMap<>();
       for( int[] prerequisite : prerequisites ){
           if( nexts.get( prerequisite[1] ) == null ) nexts.put( prerequisite[1] , new ArrayList<Integer>() );
           nexts.get( prerequisite[1] ).add( prerequisite[0] );
           degree[ prerequisite[0] ]++;
       }
       int index = 0;
       LinkedList<Integer> nowCourses = new LinkedList<Integer>();
       for( int i = 0 ; i < degree.length ; i++ ) if( degree[i] == 0 ) nowCourses.add( i );
       while( !nowCourses.isEmpty() ){
           LinkedList<Integer> nextCourses = new LinkedList<Integer>();
           for(Integer course : nowCourses ){
               res[index] = course;
               index++;
               if( nexts.get( course ) == null ) continue;
               for( Integer related : nexts.get( course )  ){
                   degree[ related ] --;
                   if( degree[ related ] == 0 ) nextCourses.add( related );
               }
           }
           nowCourses = nextCourses;
       }
       if( index != res.length ) return new int[0];
       return res;
    }
}
