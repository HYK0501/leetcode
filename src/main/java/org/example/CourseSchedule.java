package org.example;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> finishCourses = new ArrayList<>();
        int[] degrees = new int[ numCourses ];
        Map<Integer , List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < prerequisites.length ; i++ ) {
            degrees[ prerequisites[i][1] ]++;
            if( map.get( prerequisites[i][0] ) == null ) map.put(prerequisites[i][0], new ArrayList<>() );
            map.get( prerequisites[i][0] ).add( prerequisites[i][1] );
        }
        for( int i = 0 ; i < numCourses ; i++ ) if( degrees[i] == 0 ) finishCourses.add( i );
        for( int i = 0 ; i < finishCourses.size() ; i++){
            for( Integer next : map.get( finishCourses.get(i) ) ) {
                degrees[next]--;
                if( degrees[next] == 0 ) finishCourses.add( next );
            }
        }
        return finishCourses.size() == numCourses;
    }
}
