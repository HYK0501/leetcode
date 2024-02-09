package org.example;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] nextCourseMap = new List[numCourses];
        List<Integer>[] preCourseMap = new List[numCourses];
        int[] res = new int[numCourses];
        ArrayList<Integer> finalCourses = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            nextCourseMap[i] = new ArrayList<>();
            preCourseMap[i] = new ArrayList<>();
        }
        for( int i = 0 ; i < prerequisites.length ; i++){
            nextCourseMap[ prerequisites[i][1] ].add( prerequisites[i][0] );
            preCourseMap[ prerequisites[i][0] ].add( prerequisites[i][1] );
        }
        for( int i = 0 ; i < numCourses ; i++ ){
            if( nextCourseMap[i].isEmpty() ){
                finalCourses.add( i );
            }
        }
        int order = numCourses - 1;
        while( !finalCourses.isEmpty() ){
            ArrayList<Integer> nextFinalCourses = new ArrayList<>();
            for( Integer finalCourse : finalCourses){
                res[order] = finalCourse;
                for( Integer preCourse : preCourseMap[finalCourse] ){
                    nextCourseMap[preCourse].remove( finalCourse );
                    if( nextCourseMap[preCourse].isEmpty() ){
                        nextFinalCourses.add( preCourse );
                    }
                }
                order--;
            }
            finalCourses = nextFinalCourses;
        }
        if( order != -1){
            res = new int[0];
        }
        return res;
    }
}
